package utils;

/**
 * Created by androidlinux on 14/11/17.
 */

public final class CDataBase {

    public static final String nomBd = "BdPhotoUser";

    public static final class user {
        public static final String nomTable = "user";
        public static final String id = "id";
        public static final String fName = "fName";
        public static final String lName = "lName";
        public static final String login = "login";
        public static final String pwd = "pwd";
        public static final String token = "token";
    }

    public static final class image {
        public static final String nomTable = "image";
        public static final String id = "id";
        public static final String lat = "lat";
        public static final String lon = "lon";
        public static final String date = "date";
        public static final String src = "src";
    }

    public static final class userAtUser {
        public static final String nomTable = "userAtUser";
        public static final String id1 = "id1";
        public static final String id2 = "id2";
    }

    public static final class userAtImage {
        public static final String nomTable = "userAtImage";
        public static final String idUser = "idUser";
        public static final String idImage = "idImage";
    }

}
