package online.restadvidor.restadvidor.security;

public class BlackList {

	private static final String[] AUTH_ADMIN = {
		"/schedules/new",
		"/schedules/delete",
		"/rols/new",
		"/rols/update/{id}",
		"/rols/delete",
		"/rols/new",
		"/workdays/new",
		"/workdays/update/{id}",
		"/workdays/delete"
			
    };
	
	private static final String[] BOTH_MOD_ADMIN = {
			"/branchs/new",
			"/branchs/update/{id}",
			"/branchs/delete",
			"/restaurants/new",
			"/restaurants/update/{id}",
			"/restaurants/delete",
			"/schedules/update/{id}"
    };
	
	private static final String[] ALL_USER_MOD_ADMIN = {
			"/users/update",
			"/users/delete",
			"/images/delete/{imageId}",
			"uploadfile/{branchId}",
			"/opinions/new",
			"/opinions/update/{id}",
			"/opinions/delete"
    };
	

	
	public static String[] getBlackListAdmin() {
		return AUTH_ADMIN;
	}
	
	public static String[] getBlackListAdminAndMod() {
		return BOTH_MOD_ADMIN;
	}
	
	public static String[] getBlackListAll() {
		return ALL_USER_MOD_ADMIN;
	}
	
	
	
	/* private static final String[] AUTH_USER = {
	
    };
	
	private static final String[] AUTH_MODERATOR = {	
    };
    */
}
