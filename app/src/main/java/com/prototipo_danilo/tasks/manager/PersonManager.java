package com.prototipo_danilo.tasks.manager;

import android.content.Context;
import android.os.AsyncTask;

import com.prototipo_danilo.tasks.business.PersonBusiness;
import com.prototipo_danilo.tasks.infra.operation.OperationListener;
import com.prototipo_danilo.tasks.infra.operation.OperationResult;

public class PersonManager {

    private PersonBusiness mpersonBusiness;

    public PersonManager(Context context){
        this.mpersonBusiness = new PersonBusiness(context);
    }

    public void Create(String name, String email, String password, final OperationListener listener){
        AsyncTask<Void,Void,OperationResult<Boolean>> task = new AsyncTask<Void, Void, OperationResult<Boolean>>() {
            @Override
            protected OperationResult<Boolean> doInBackground(Void... voids) {
                //implentacao da Businnes
                return mpersonBusiness.create();
            }

            @Override
            protected void onPostExecute(OperationResult<Boolean> result){//retorna um objeto anonimo do tipo boolean para finalizar a thread
                int error = result.getError();
                if(error != OperationResult.NO_ERROR){
                    //existe erro
                    listener.OnError(error,result.getErrorMessage());
                }
                else {
                    listener.OnSucess(result.getResult());
                }
            }
        };

        //Executa a thread
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }
}
