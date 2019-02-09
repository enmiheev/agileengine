package Common;

public class Environment {
    private static String PageAccessToken = "EAAHiSQjBZCUEBALHt8ezG8yd26EhpXktBe7xvin9DWz6qRdGHU9uiD4gT7e1HucRusWg5EjZBXxRoSAR0c97dX9DJzFkugPdaCiyb8Osl8HPZClOTKdEuUit90cTDJZBB0ezZCuPBd0ZCOPX0d3Vy0ZBxS3kVRKxUUHrnZA7Cs6cMpy8tZAXFNxyV3OlahZCeJ6t4ZD";
    private static String UserEmail = "open_gxeerqv_user@tfbnw.net";
    private static String UserPassword = "Test1234Test1234";
    private static String GraphBaseUrl = "https://graph.facebook.com/";
    private static String GraphVersion = "v3.2";

    public static String getPageAccessToken() {
        return PageAccessToken;
    }

    public static String getUserEmail() {
        return UserEmail;
    }

    public static String getUserPassword() {
        return UserPassword;
    }

    public static String getGraphBaseUrl() {
        return GraphBaseUrl;
    }

    public static String getGraphVersion() {
        return GraphVersion;
    }
}
