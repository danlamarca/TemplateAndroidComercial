package com.prototipo_danilo.tasks.business;

import android.content.Context;

import com.google.gson.Gson;
import com.prototipo_danilo.tasks.constants.TaskConstants;
import com.prototipo_danilo.tasks.entities.APIResponse;
import com.prototipo_danilo.tasks.entities.FullParameters;
import com.prototipo_danilo.tasks.entities.JsonPlaceHolderEntity;
import com.prototipo_danilo.tasks.infra.SecurityPreferences;
import com.prototipo_danilo.tasks.infra.URLBuilder;
import com.prototipo_danilo.tasks.infra.operation.OperationListener;
import com.prototipo_danilo.tasks.infra.operation.OperationResult;
import com.prototipo_danilo.tasks.repository.api.ExternalRepository;

import java.util.AbstractMap;
import java.util.HashMap;

public class PersonBusiness {

    private ExternalRepository mExternalRepository;
    private Context mcontext;

    public PersonBusiness(Context context){
        this.mExternalRepository = new ExternalRepository(context);
        this.mcontext = context;
    }

    public OperationResult<Boolean> create(){
        OperationResult<Boolean> result = new OperationResult<>();

        try {
            //constroi a URL:
            URLBuilder builder = new URLBuilder(TaskConstants.ENDPOINT.ROOT2);
            builder.addResource(TaskConstants.ENDPOINT.ID1);
            String URLfinal = builder.getURL();

            //heades nullos - jsonplaceholder nao necessita de headers
            AbstractMap<String, String> headers = new HashMap<>();
            headers.put(null, null);

            //parametros de consulta, para a API jsonplaceholder nao há necessidade de params:
            AbstractMap<String, String> params = new HashMap<>();
            params.put(null, null);

            FullParameters full = new FullParameters(TaskConstants.OPERATION_METHOD.GET, URLfinal, null, null);

            //chamada da API
            APIResponse response = this.mExternalRepository.Execute(full);
            //tratar o json
            if(response.statusCode== TaskConstants.STATUS_CODE.SUCCESS){
                JsonPlaceHolderEntity jsonPlaceHolderEntity = new Gson().fromJson(response.json,JsonPlaceHolderEntity.class);
                //guardar informações no sharedPreferences:
                SecurityPreferences securityPreferences = new SecurityPreferences(this.mcontext);
                securityPreferences.storeString("titulo",jsonPlaceHolderEntity.title);
                securityPreferences.storeString("id", jsonPlaceHolderEntity.getid());

                result.setResult(true);
            }else{
                result.setResult(false);
            }


        }
        catch(Exception e){

            return result;
        }


        return result;
    }
}
