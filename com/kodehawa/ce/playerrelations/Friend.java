package com.kodehawa.ce.playerrelations;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.kodehawa.ce.forge.loader.CheatingEssentials;

import cpw.mods.fml.client.FMLClientHandler;

public class Friend {

    public final static ArrayList<String> friendList = new ArrayList<String>();
    private static File friendsFile;
    private volatile static Friend instance;

    public Friend( ){
        friendsFile = new File(FMLClientHandler.instance().getClient().mcDataDir, "/config/Cheating Essentials/CEFriendsList.txt");
        friendList.add("Kodehawa");


        if(!friendsFile.exists()){
            friendsFile.getParentFile().mkdirs();
            try{
                friendsFile.createNewFile();
                writeFriendList();
            }
            catch(Exception e){}
        }
        loadFriendList();
    }

    public static void writeFriendList(){
    	CheatingEssentials.instance().log("Writing Friend file...");
        try{
            FileWriter filewritter = new FileWriter(friendsFile);
            BufferedWriter bufferedwriter = new BufferedWriter(filewritter);
            for(String s : friendList){
                bufferedwriter.write(s + "\r\n");
            }
            bufferedwriter.close();
        }
        catch (Exception e){
        	CheatingEssentials.instance().log("Can't write Friends file! " + e);
        }
    }

    public static void loadFriendList(){
        try {
            File file = new File( friendsFile, "" );
            FileInputStream fstream = new FileInputStream( file.getAbsolutePath( ) );
            DataInputStream in = new DataInputStream( fstream );
            BufferedReader br = new BufferedReader( new InputStreamReader( in ) );
            String line;
            while( ( line = br.readLine( ) ) != null ) {
                String string = line.toLowerCase( ).trim( );
                friendList.add( string + "\r\n" );
            }
            br.close( );
        } catch( Exception ex ) {
        	CheatingEssentials.instance().log("Can't load Friends list. Unreliable results!");
        	CheatingEssentials.instance().log( "Error in CE init: " + ex.toString( ) );
            ex.printStackTrace( );
            writeFriendList( );
        }
    }

    public boolean isFriendInList( String s ){
        if(friendList.contains(s)){
           return true;
        }
        else{
            return false;
        }
    }

    public static Friend getInstance(){
        if(instance == null){
            instance = new Friend();
        }
        return instance;
    }

}