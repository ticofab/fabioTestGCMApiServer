package com.api.fabiotest;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.google.android.gcm.server.*;

@Path("/")
public class Welcome {
    private final static String mWelcome = "Welcome to fabioTestApiServer";
    private final static String mHTCIncApp = "APA91bHqMEJb_s36jMEaTH0Wouadrlu619EDJhyhp6F3Fm1vqtULgmvcLxhjjkrJeJ893ZDHkjuQ7qpzJ1883XaS9njWouQ68LDhbqT6bQr97XOWlF2_0SbBHO52Bd2uLPlLf7zlpVT5CSwmME2NljJwdwcBk5i_cQ";
    private final static String mChocBarApp = "APA91bEszJftFhkAyCRYiWZ8-ZmiSvOIRw6SeDqmYlKoEglhLSpPna_5fTA8lYq2ciyIvh8eU0SzPfKYrdCCO5NpSAyJdrYdWhTOp1-9w1IXotM3pKral7MljhqQytVfoBS2anJd9NFCI1lGyoiutp2YvUhqnedNeg";
    private final static String mProjectAPIID = "1014164223629";
    private final static String mApiID = "AIzaSyDJTfll_jwqDa1r8xqimbgGnEQiXeSw_kA";

    /*
     * my mobile phone
     * 
     */

    @GET
    @Path("{model}")
    public String getWelcome(@PathParam("model") String model) {
        String recipient = null;
        if (model.equals("htc")) {
            recipient = mHTCIncApp;
        } else if (model.equals("sg3")) {
            recipient = mChocBarApp;
        }

        String retString = "you didn't send the model.";
        if (recipient != null) {
            Sender sender = new Sender(mApiID);
            Message message = new Message.Builder().addData("message", "push notificatie bericht").build();
            Result result = null;
            try {
                result = sender.send(message, recipient, 5);
                System.out.println(result.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
            retString = mWelcome;
        }

        return retString;
    }
}
