package com.rakesh.librarymanagementsystem.constant;

/**
 *
 * @author Rakesh Kuchana
 */
public interface AppConstants
{
    public static final String SESSION_USER = "session_user";
    public static final String PATH_CSS = "/libraryManagementSystem/css";
    public static final String PATH_JS = "/libraryManagementSystem/js";
    public static final String PATH_HTML="/libraryManagementSystem/html";
    public static final String URI_LOGIN = "/libraryManagementSystem/login";
    public static final String ATTR_URI_TARGET = "targetURI";
    public static final String URI_LOGIN_CONTROLLER = "/libraryManagementSystem/loginController";
    public static final String URI_HOME = "/libraryManagementSystem/home";
    public static final String URI_REGISTRATION_LINK = "/libraryManagementSystem/registrationLn";
    public static final String URI_REGISTRATION_COMPLETE =  "/libraryManagementSystem/registrationComplete";
    public static final String ROLE_ADMIN = "admin";
    public static final String ROLE_LIBRARIAN = "librarian";
    public static final String JSP_ADMIN_HOME = "/WEB-INF/jsp/admin/home.jsp";
    public static final String JSP_LIBRARIAN_HOME = "/WEB-INF/jsp/librarian/home.jsp";
    public static final String JSP_REGISTRATION_COMPLETE = "/WEB-INF/jsp/registrationComplete.jsp";
    public static final String PATH_IMG = "/libraryManagementSystem/img";
    public static final String PARAM_USER_NAME = "username";
    public static final String PARAM_PASSWORD = "password";
    public static final String PARAM_FIRST_NAME = "firstName";
    public static final String PARAM_LAST_NAME = "lastName";
    public static final String PARAM_EMAIL_ADDRESS = "emailAddress";
    public static final String PARAM_GENDER = "gender";
    public static final String PARAM_DAY = "day";
    public static final String PARAM_MONTH = "month";
    public static final String PARAM_YEAR = "year";
    public static final String PARAM_USER_ID = "userId";
    public static final String PARAM_NEW_PASSWORD = "newPassword";
    public static final String PARAM_REG_ID = "regId";
    public static final String ATTR_ERROR_MSG = "errMsg";
    public static final String ATTR_REGISTRATION_RESPONSE = "registrationResponse";
    public static final String ATTR_USER = "user";
    public static final String ATTR_REGISTRATION = "registration";
    public static final String MSG_INVALID_CREDS = "Invalid Credentials";
    public static final String DRIVER_CLASS = "driver.class";
    public static final String DRIVER_URL = "driver.url";
    public static final String DB_USERNAME = "username";
    public static final String DB_PASSWORD = "password";
    public static final String DATASOURCE_PROPERTIES = "lms.datasource.properties";
    public static final String DATASOURCE_FILE_PATH = "datasource.file.path";
    public static final String APPLICATION_PROPERTIES = "application.properties";
    public static final String MAIL_PROPERTIES = "mail.properties";
    public static final String MSG_MAIL_SENT = "Mail has been sent to complete registration";
    public static final String MSG_ALREADY_REGISTERED_EMAIL = "A user is already registered with this email address";
    public static final String MSG_ALREADY_USED_USER_ID = "User ID already used. Choose a different ID"; 
    public static final String MSG_INVALID_REGISTRATION_LINK = "Invalid registration link";
    public static final char CHAR_FORWARD_SLASH = '/';
    
    
}
