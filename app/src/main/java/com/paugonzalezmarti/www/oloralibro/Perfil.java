package com.paugonzalezmarti.www.oloralibro;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Perfil extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfil);

        Button buton_ok = (Button)findViewById(R.id.button_perfil_OK);
        buton_ok.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                try
                {
                    finish();
                } catch (Throwable throwable)
                {
                    throwable.printStackTrace();
                }
            }
        });
    }
}
