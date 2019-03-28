package com.prototipo_danilo.tasks.constants;

public class TaskConstants {

    //CLASSE DE REQUISIÇÕES: API integracao prototipo_danilo (Utilizando jsonPlaceHolder)

    //header das requisiçoes:
    public static class HEADER {
        public static final String TOKEN_KEY="token";
        public static final String PERSON_KEY="personkey";
    }

    public static class ENDPOINT {
        //URL´s para exemplo
        public static final String ROOT1="ws.correios.com.br";
        public static final String ROOT2="https://jsonplaceholder.typicode.com/todos";

        public static final String AUTHENTICATION_CREATE="Authentication/Create";
        public static final String AUTHENTICATION_LOGIN="Authentication/Login";

        //tasks:
        public static final String TASK_GET_LIST_NO_FILTER = "Task";
        public static final String TASK_GET_LIST_OVERRIDE="Task/Overdue";
        public static final String TASK_GET_NEXT_7_DAYS="Task/Next7Days";
        public static final String TASK_GET_ESPECIFIC="Task";
        public static final String TASK_DELETE="Task";
        public static final String TASK_UPDATE="Task";
        public static final String TASK_INSERT="Task";
        public static final String TASK_COMPLETE="Task/Complete";
        public static final String TASK_UNCOMPLETE="Task/Uncomplete";

        //ID´s
        public static final String ID1="1";
        public static final String ID2="2";
        public static final String ID3="3";
        public static final String PRIORITY_GET="priority";
    }

    public static class OPERATION_METHOD {
        public static final String GET= "GET";
        public static final String PUT="PUT";
        public static final String DELETE ="DELETE";
        public static final String POST="POST";
    }


    public static class STATUS_CODE {
        public static final int SUCCESS=200;
        public static final int FORBIDDEN=403;
        public static final int NOT_FOUND=404;
        public static final int INTERNAL_SERVER_ERROR=500;
        public static final int INTERNET_NOT_AVAILABLE=901;
    }

}
