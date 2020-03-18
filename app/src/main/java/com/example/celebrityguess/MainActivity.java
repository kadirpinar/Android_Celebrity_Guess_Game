package com.example.celebrityguess;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {

    ImageView iv;
    TextView tv;
    Button b0;
    Button b1;
    Button b2;
    Button b3;

    ArrayList<String> CelebNames= new ArrayList<>();
    ArrayList<String> CelebImgUrl= new ArrayList<>();

    public class DownloadImage extends AsyncTask<String,Void, Bitmap>{


        /**
         * Override this method to perform a computation on a background thread. The
         * specified parameters are the parameters passed to {@link #execute}
         * by the caller of this task.
         * <p>
         * This method can call {@link #publishProgress} to publish updates
         * on the UI thread.
         *
         * @param strings The parameters of the task.
         * @return A result, defined by the subclass of this task.
         * @see #onPreExecute()
         * @see #onPostExecute
         * @see #publishProgress
         */
        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                URL url= new URL(strings[0]);
                HttpURLConnection con= (HttpURLConnection) url.openConnection();
                con.connect();
                InputStream in =con.getInputStream();
                final Bitmap bmp= BitmapFactory.decodeStream(in);

                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        iv.setImageBitmap(bmp);
                    }
                });

                return bmp;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }
    }

    public class DownloadContent extends AsyncTask<String,Void,String>{

        /**
         * Override this method to perform a computation on a background thread. The
         * specified parameters are the parameters passed to {@link #execute}
         * by the caller of this task.
         * <p>
         * This method can call {@link #publishProgress} to publish updates
         * on the UI thread.
         *
         * @param strings The parameters of the task.
         * @return A result, defined by the subclass of this task.
         * @see #onPreExecute()
         * @see #onPostExecute
         * @see #publishProgress
         */
        @Override
        protected String doInBackground(String... strings) {
            try {
                Document doc = Jsoup.connect(strings[0]).get();

                final Elements imgs =doc.select("img");
                Log.i("Size",imgs.size()+"");

                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        Pattern name= Pattern.compile("<img alt=\"(.*?)\"");
                        Pattern url= Pattern.compile("src=\"(.*?)\"");

                        Matcher m;

                        for(Element e:imgs){
                            if(e.toString().contains("height=\"209\"")){
                                m=name.matcher(e.toString());
                                boolean git=false;
                                while(m.find())
                                {git=true;
                                    CelebNames.add(m.group(1));
                                }
                                if(git){
                                    m=url.matcher(e.toString());
                                    while(m.find())
                                        CelebImgUrl.add(m.group(1));
                                }
                                git=false;
                            }
                        }
                        Log.i("Sonuc",imgs.html());
                        update();
                    }
                });


            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }
    }

    public void update(){

        Random rnd= new Random();

        int Celeb1= rnd.nextInt(100);
        int Celeb2= rnd.nextInt(100);
        int Celeb3= rnd.nextInt(100);
        int Celeb4= rnd.nextInt(100);

        int x=rnd.nextInt(4+1);
        if(x==1) {
            b0.setText(CelebNames.get(Celeb1));
            b0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dogru++;
                    count++;
                    tv.setText("" + dogru + "/" + count);
                    update();
                }
            });
            b1.setText(CelebNames.get(Celeb2));
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    count++;
                    tv.setText("" + dogru + "/" + count);
                    update();
                }
            });
            b2.setText(CelebNames.get(Celeb3));
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    count++;
                    tv.setText("" + dogru + "/" + count);
                    update();
                }
            });
            b3.setText(CelebNames.get(Celeb4));
            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    count++;
                    tv.setText("" + dogru + "/" + count);
                    update();
                }
            });
        }
        else  if(x==2) {
            b0.setText(CelebNames.get(Celeb2));
            b0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    count++;
                    tv.setText("" + dogru + "/" + count);
                    update();
                }
            });
            b1.setText(CelebNames.get(Celeb1));
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dogru++;
                    count++;
                    tv.setText("" + dogru + "/" + count);
                    update();
                }
            });
            b2.setText(CelebNames.get(Celeb3));
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    count++;
                    tv.setText("" + dogru + "/" + count);
                    update();
                }
            });
            b3.setText(CelebNames.get(Celeb4));
            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    count++;
                    tv.setText("" + dogru + "/" + count);
                    update();
                }
            });
        }
        else if(x==3) {
            b0.setText(CelebNames.get(Celeb2));
            b0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    count++;
                    tv.setText("" + dogru + "/" + count);
                    update();
                }
            });
            b1.setText(CelebNames.get(Celeb3));
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    count++;
                    tv.setText("" + dogru + "/" + count);
                    update();
                }
            });
            b2.setText(CelebNames.get(Celeb1));
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dogru++;
                    count++;
                    tv.setText("" + dogru + "/" + count);
                    update();
                }
            });
            b3.setText(CelebNames.get(Celeb4));
            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    count++;
                    tv.setText("" + dogru + "/" + count);
                    update();
                }
            });
        }
        else if(x==4) {
            b0.setText(CelebNames.get(Celeb2));
            b0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    count++;
                    tv.setText("" + dogru + "/" + count);
                    update();
                }
            });
            b1.setText(CelebNames.get(Celeb3));
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    count++;
                    tv.setText("" + dogru + "/" + count);
                    update();
                }
            });
            b2.setText(CelebNames.get(Celeb4));
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    count++;
                    tv.setText("" + dogru + "/" + count);
                    update();
                }
            });
            b3.setText(CelebNames.get(Celeb1));
            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dogru++;
                    count++;
                    tv.setText("" + dogru + "/" + count);
                    update();
                }
            });
        }

        DownloadImage di= new DownloadImage();
        di.execute(CelebImgUrl.get(Celeb1));


        // DownloadContent dc= new DownloadContent();
        // dc.execute("https://www.imdb.com/list/ls052283250/");

    }
    public int count=0;
    public int dogru=0;


    public void Selection(View v){
        update();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv=(ImageView) findViewById(R.id.imageView);
        tv=(TextView) findViewById(R.id.textView3);
        b0=(Button)findViewById(R.id.button0);
        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        DownloadContent dc= new DownloadContent();
        dc.execute("https://www.imdb.com/list/ls052283250/");
        tv.setText("0/1" );




    }


}

