package ttos;
import java.util.Locale;
import java.util.Scanner;
import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;
import java.nio.file.*;
import java.io.*; 
import java.lang.*;

public class TXTToSpeech
{
	 
    public static String readFileAsString(String fileName)throws IOException
    {  
        String data="";
        data=new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }
    public static void main(String args[])throws IOException
    {	
    	Scanner sc = new Scanner(System.in);
    	BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
    	int i=1;
    	do {
    		
    		System.out.println("PRESS 1 : WANT TO WRITE TEXT IN FILE");
    		System.out.println("PRESS 2 : WANT TO LISTEN TEXT IN FILE");
    		System.out.println("PRESS 3 : WANT TO WRITE AND LISTEN TEXT IN FILE");
    	
    	    int in = sc.nextInt();
    	
    	    switch(in)
    	    {
    	    	case 1: System.out.println("Enter the text you want to write in file");
    	        		String name=b.readLine();
    	        		FileWriter fw=new FileWriter("Voice.txt");
    	        		BufferedWriter bw=new BufferedWriter(fw);
    	        		PrintWriter pw=new PrintWriter(bw);
    	        		pw.println(name);
    	        		pw.close();
    	        		bw.close();
    	        		fw.close();
    	        		break;
    	        
    	    	case 2: String st=readFileAsString("Voice.txt");
    	    			try
    	    			{
    	    				System.setProperty("freetts.voices","com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
    	    				Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
    	    				Synthesizer synthesizer=Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));      
    	    				// Allocate synthesizer
    	    				synthesizer.allocate();              
    	    				// Resume Synthesizer
    	    				synthesizer.resume();    
    	    				// speaks the given text until queue is empty.
    	    				synthesizer.speakPlainText(st, null);          
    	    				synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
    	    				// Deallocate the Synthesizer.
    	    				//synthesizer.deallocate();    
    	    			}    
    	    			catch (Exception e)  
    	    			{
    	    				System.out.println("ERROR");
    	    			}
    	    			break;
    	    	
    	    	case 3: System.out.println("Enter the text you want to write and listen in file");
    	    			String name2=b.readLine();
    	    			FileWriter fw2=new FileWriter("Voice.txt");
    	    			BufferedWriter bw2=new BufferedWriter(fw2);
    	    			PrintWriter pw2=new PrintWriter(bw2);
    	    			pw2.println(name2);
    	    			pw2.close();
    	    			bw2.close();
    	    			fw2.close();
      
    	    			String st2=readFileAsString("Voice.txt");
            
    	    			System.out.println("written in file: "+st2);
    	    			try
    	    			{
    	    				System.setProperty("freetts.voices","com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
    	    				Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
    	    				Synthesizer synthesizer=Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));      
    	    				// Allocate synthesizer
    	    				synthesizer.allocate();              
    	    				// Resume Synthesizer
    	    				synthesizer.resume();    
    	    				// speaks the given text until queue is empty.
    	    				synthesizer.speakPlainText(st2, null);          
    	    				synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
    	    				// Deallocate the Synthesizer.
    	    				//synthesizer.deallocate();    
    	    			}    
    	    			catch (Exception e)  
    	    			{
    	    				System.out.println("ERROR");
    	    			}   
    	    			break;
    	    	default: System.out.println("wrong entry");
    	    }
    	    System.out.println("PRESS 1 TO CONTINUE OR PRESS 0 TO EXIT");
    	
    	    i = sc.nextInt();
    	}
    	while(i==1);
    }
}