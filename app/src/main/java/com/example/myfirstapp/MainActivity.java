package com.example.myfirstapp;

import android.app.assist.AssistStructure;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity{
    public int counter=10;
    private static final String SHARED_PREFS ="sharedprefs";
    public static final String TEXT ="text";
    View view;
    TextView textView;
    Button Submit1,Submit2,Submit3,Submit4,Next,Score,Submit5;
    EditText editText;
    int num,j,k=0,p,r=2,s=0,h=0;
    int a[]=new int[1000000];
    int b[]=new int[1000000];
    int i,score=0;
    int f;
    String ans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Vibrator vibrator=(Vibrator)
        MainActivity.this.getSystemService(Context.VIBRATOR_SERVICE);
        textView = findViewById(R.id.textView2);
        editText = findViewById(R.id.editText3);
        Submit1 = findViewById(R.id.button);
        Submit2 = findViewById(R.id.button2);
        Submit3 = findViewById(R.id.button3);
        Submit4 = findViewById(R.id.button4);
        Submit5=findViewById(R.id.button10);
        Next = findViewById(R.id.button6);
        Score = findViewById(R.id.button7);
        Log.d("tag", "iam in acctivity1");
        Next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                savedata();
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                intent.putExtra("KEY", score);
                startActivity(intent);

            }
        });
        Submit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CountDownTimer countdowntimer=new CountDownTimer(11000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        Submit5.setText(String.valueOf(counter));
                        counter--;
                    }
                    @Override
                    public void onFinish() {
                        if(h==0){
                            String fs=""+Score.getText().toString();
                            textView.setText("Your time is up\n Your Final score: "+fs);
                            score=0;
                            String fn=""+score;
                            Score.setText(fn);
                        }
                    }
                }.start();

                num = Integer.parseInt(editText.getText().toString());
                for (j = 1; j <= num; j++) {
                    if (num % j == 0) {
                        a[k] = j;
                        k++;
                    }
                }

                p = k / 2;
                String answer = " " + a[p];
                Log.d("tag", "i got answer");
                int s = 0;
                for (r = 2; r < num; r++) {
                    for (j = 1; j < k; j++) {
                        if (a[j] != r) {
                            b[s] = r;
                            s++;
                        }
                    }
                }
                p=s/2;
                int z=s/3;
                String answer2 = " " + b[p];
                String answer3 = " " + b[z];
                if (num % 3 == 0) {
                    Submit2.setText(answer2);
                    Submit3.setText(answer);
                    Submit4.setText(answer3);
                    Submit3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            h=1;
                            Submit3.setBackgroundColor(getResources().getColor(R.color.green));
                            textView.setText("You entered right answer");
                            Submit2.setBackgroundColor(getResources().getColor(R.color.red));
                            Submit4.setBackgroundColor(getResources().getColor(R.color.red));
                            score=Integer.parseInt(Score.getText().toString().trim());
                            score++;
                            String ans=""+score;
                            Score.setText(ans);
                            f=score;
                        }
                    });
                    Submit2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            h=1;
                            vibrator.vibrate(80);
                            Submit2.setBackgroundColor(getResources().getColor(R.color.red));
                            Submit4.setBackgroundColor(getResources().getColor(R.color.red));
                            Submit3.setBackgroundColor(getResources().getColor(R.color.green));
                            score=Integer.parseInt(Score.getText().toString().trim());
                            String finale="Your final Score: "+score;
                            textView.setText("Oops Wrong answer\n"+finale);
                            score=0;
                            String ans=""+score;
                            Score.setText(ans);
                            savedata();
                        }
                    });
                    Submit4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            h=1;
                            vibrator.vibrate(80);
                            Submit4.setBackgroundColor(getResources().getColor(R.color.red));
                            Submit2.setBackgroundColor(getResources().getColor(R.color.red));
                            Submit3.setBackgroundColor(getResources().getColor(R.color.green));
                            score=Integer.parseInt(Score.getText().toString().trim());
                            String finale="Your final Score: "+score;
                            textView.setText("Oops Wrong answer\n"+finale);
                            score=0;
                            String ans=""+score;
                            Score.setText(ans);
                            savedata();
                        }
                    });
                } else if (num % 3 == 2) {
                    Submit2.setText(answer);
                    Submit3.setText(answer2);
                    Submit4.setText(answer3);
                    Submit2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            h=1;
                            Submit2.setBackgroundColor(getResources().getColor(R.color.green));
                            textView.setText("You entered right answer");
                            Submit3.setBackgroundColor(getResources().getColor(R.color.red));
                            Submit4.setBackgroundColor(getResources().getColor(R.color.red));
                            score=Integer.parseInt(Score.getText().toString().trim());
                            score++;
                            ans = "" + score;
                            Score.setText(ans);
                            f=score;
                        }
                    });
                    Submit3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            h=1;
                            vibrator.vibrate(80);
                            Submit3.setBackgroundColor(getResources().getColor(R.color.red));
                            Submit2.setBackgroundColor(getResources().getColor(R.color.green));
                            Submit4.setBackgroundColor(getResources().getColor(R.color.red));
                            score=Integer.parseInt(Score.getText().toString().trim());
                            String finale="Your final Score: "+score;
                            textView.setText("Oops Wrong answer\n"+finale);
                            score=0;
                            String ans=""+score;
                            Score.setText(ans);
                            savedata();
                        }
                    });
                    Submit4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            h=1;
                            vibrator.vibrate(80);
                            Submit4.setBackgroundColor(getResources().getColor(R.color.red));
                            Submit3.setBackgroundColor(getResources().getColor(R.color.red));
                            Submit2.setBackgroundColor(getResources().getColor(R.color.green));
                            score=Integer.parseInt(Score.getText().toString().trim());
                            String finale="Your final Score: "+score;
                            textView.setText("Oops Wrong answer\n"+finale);
                            score=0;
                            String ans=""+score;
                            Score.setText(ans);
                            savedata();
                        }
                    });
                } else {
                    Submit4.setText(answer);
                    Submit3.setText(answer2);
                    Submit2.setText(answer3);
                    Submit4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            h=1;
                            Submit4.setBackgroundColor(getResources().getColor(R.color.green));
                            textView.setText("You entered right answer");
                            Submit2.setBackgroundColor(getResources().getColor(R.color.red));
                            Submit3.setBackgroundColor(getResources().getColor(R.color.red));
                            score=Integer.parseInt(Score.getText().toString().trim());
                            score++;
                            ans = "" + score;
                            Score.setText(ans);

                            f=score;
                        }
                    });
                    Submit3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            h=1;
                            vibrator.vibrate(80);
                            Submit3.setBackgroundColor(getResources().getColor(R.color.red));
                            Submit4.setBackgroundColor(getResources().getColor(R.color.green));
                            Submit2.setBackgroundColor(getResources().getColor(R.color.red));
                            score=Integer.parseInt(Score.getText().toString().trim());
                            String finale="Your final Score: "+score;
                            textView.setText("Oops Wrong answer\n"+finale);
                            score=0;
                            String ans=""+score;
                            Score.setText(ans);
                            savedata();
                        }
                    });
                    Submit2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            h=1;
                            vibrator.vibrate(500);
                            Submit2.setBackgroundColor(getResources().getColor(R.color.red));
                            Submit3.setBackgroundColor(getResources().getColor(R.color.red));
                            Submit4.setBackgroundColor(getResources().getColor(R.color.green));
                            score=Integer.parseInt(Score.getText().toString().trim());
                            String finale="Your final Score: "+score;
                            textView.setText("Oops Wrong answer\n"+finale);
                            score=0;
                            String ans=""+score;
                            Score.setText(ans);
                            savedata();
                        }
                    });

                }

                j = 1;
                p = 0;
                k = 0;
                s = 0;
            }
        });
        updateViews();
    }

    public void savedata(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(TEXT, Score.getText().toString());
        editor.apply();
    }

    public void updateViews() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        String text = sharedPreferences.getString(TEXT, "");
        String ran=""+text;
        Score.setText(text);
    }

}
