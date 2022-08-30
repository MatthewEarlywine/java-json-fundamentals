package uk.co.monotonic.json_fundamentals._2_producing_json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import uk.co.monotonic.json_fundamentals.common.LoanApplication;

import java.io.IOException;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class ProducingWithBindingApi
{
    public static void main(String[] args) throws IOException
    {
        LoanApplication loanApplication = ExampleLoan.LOAN_APPLICATION;
        System.out.println(loanApplication);
        System.out.println();

        toJsonString(loanApplication);
    }

    private static void toJsonString(final LoanApplication loanApplication) throws IOException
    {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        
        String jsonString = objectWriter.writeValueAsString(loanApplication); // <-- This option works best if you want to do
        System.out.println(jsonString); 									// something with the JSON String besides writing it
        																	// into a stream.
        
      //objectWriter.writeValue(System.out, loanApplication);     <--Whereas this option sends our value directly 
        															//		to an output stream 
    }
}
