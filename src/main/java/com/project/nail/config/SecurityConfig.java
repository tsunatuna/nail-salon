package com.project.nail.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.project.nail.framework.security.LoginAuthenticationFailureHandler;
import com.project.nail.service.JdbcUserDetailsServiceImpl;

/**
 * Spring Security設定クラス.
 */
@Configuration
@EnableWebSecurity   // Spring Securityの基本設定
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JdbcUserDetailsServiceImpl userDetailsService;

	@Override
	public void configure(WebSecurity web) throws Exception {
		// セキュリティ設定を無視するリクエスト設定
		// 静的リソース(images、css、javascript)に対するアクセスはセキュリティ設定を無視する
		web.ignoring().antMatchers(
							"/common/**",
							"/css/**",
							"/img/**",
							"/js/**",
							"/scss/**",
							"/vendor/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 認可の設定
		http.authorizeRequests()
			.antMatchers("/", "/login", "/top", "/design", "/contact", "/access").permitAll() // indexは全ユーザーアクセス許可
			.anyRequest().authenticated();  // それ以外は全て認証無しの場合アクセス不許可

		// ログイン設定
		http.formLogin() // ログインページに飛ばす
			.loginProcessingUrl("/loginCheck")   // 認証処理のパス
			.loginPage("/login")			// ログインフォームのパス
			// .failureUrl("?error")
			.failureHandler(new LoginAuthenticationFailureHandler())		// 認証失敗時に呼ばれるハンドラクラス
			.defaultSuccessUrl("/top", false)	 // 認証成功時の遷移先
			.usernameParameter("login_id").passwordParameter("login_password")  // ユーザー名、パスワードのパラメータ名
			.and();

		// ログアウト設定
		http.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout**"))	   // ログアウト処理のパス
			.logoutSuccessUrl("/top").permitAll();										// ログアウト完了時のパス

	}

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth)
			throws Exception {
		// 認証するユーザーを設定する
		auth.userDetailsService(userDetailsService)
		// 入力値をbcryptでハッシュ化した値でパスワード認証を行う
		.passwordEncoder(new BCryptPasswordEncoder());
	}
}