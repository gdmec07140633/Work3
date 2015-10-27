package pr3.demo.com.work3;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class HeightCalculatorActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editText;
    private CheckBox man;
    private CheckBox woman;
    private TextView v2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_height_calculator);
        editText=(EditText)findViewById(R.id.weight);
        man=(CheckBox)findViewById(R.id.man);
        woman=(CheckBox)findViewById(R.id.woman);
        v2=(TextView)findViewById(R.id.result);
        Button b=(Button)findViewById(R.id.calculator);
        b.setOnClickListener(this);

    }

    public void message(String ss){
        final AlertDialog dialog=new AlertDialog.Builder(this).create();
        dialog.setMessage(ss);
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void onClick(View view) {
        String s=editText.getText().toString();
        if(!s.equals("")){
            Double ff=Double.parseDouble(s);
            double boy=170-(62-ff)/0.6;
            double girl=158-(52-ff)/0.5;
            if(man.isChecked()&&!woman.isChecked()){
                v2.setText("先生你的身高大约为："+boy+"厘米");
            }else if(!man.isChecked()&&woman.isChecked()){
                v2.setText("姑娘你的身高大约为："+girl+"厘米");
            }
            else if(man.isChecked()&&woman.isChecked()) {
                v2.setText("男的身高大约为："+boy+"厘米\r\n女的身高大约为："+girl+"厘米");
            }else{
                message("请选择性别!");
            }
        }else{
            message("请输入体重！");
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        menu.add(menu.NONE, 0, menu.NONE, "退出");
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch (menuItem.getItemId()){
            case 0:
                finish();
                break;
        }
        return true;
    }
}


