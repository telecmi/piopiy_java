package com.telecmi.piopiy;


import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;


public class PlayAudio {

public static void main(String args[]) throws Exception {
  
JSONObject play = new JSONObject();
play.put("url","https://example.com/voice/thanks.wav");


JSONObject json = new JSONObject();
BigInteger to = new BigInteger("1234567890");

json.put("appid",1111);
json.put("secret","z76jkk");
json.put("to",to);
json.put("play",play);

String baseurl = "https://piopiy.telecmi.com/v1/playaudio";


DefaultHttpClient client = new DefaultHttpClient();
HttpPost post = new HttpPost(baseurl);
post.setHeader("Accept", "application/json");
post.setHeader("headerValue", "HeaderInformation");

StringEntity entity = new StringEntity(json.toString(), "UTF8");
entity.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
post.setEntity(entity);


HttpResponse response = client.execute(post);
HttpEntity objEntity = response.getEntity();

StringWriter writer=new StringWriter();
IOUtils.copy(objEntity.getContent(),writer);
System.out.println("==="+writer.toString());



    }



}