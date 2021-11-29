package online.restadvidor.restadvidor.security;

public class WhiteList {
	
	
	
	private static final String[] AUTH_WHITELIST = {
            // -- swagger ui
            "/v3/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/**",
            "/configuration/security",
            "/swagger-ui.html",
            "/csrf",
            "/",
            "/webjars/**",
            // other public endpoints of your API may be appended to this array
            "/branchs/all",
            "/branchs/{id}",
			"/images/all",
			"/images/{id}",
			"/opinions/all",
			"/opinions/{id}",
			"/restaurants/all",
			"/restaurants/{id}",
			"/schedules/all",
			"/schedules/{id}",
			"/rols/all",
			"/rols/{id}",
			"/users/all",
			"/users/{id}",
			"/workdays/all",
			"/workdays/{id}",
			"/users/new"
    };

	
	public static String[] getWhiteList() {
		return AUTH_WHITELIST;
	}
}
