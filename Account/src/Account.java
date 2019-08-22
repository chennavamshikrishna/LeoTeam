import java.util.Random;
import java.util.UUID;
public class Account
{

    public static String getUUID(UUID uuid)
    {
    	String str = uuid.toString();
    	str = str.toString().replace("-","");
    	Random ran = new Random();
        int rand1 = ran.nextInt(25);
        int rand2 = rand1 +3;

       
        String account1 = str.substring(rand1,rand2);
        char[] account = account1.toCharArray();

        for(int i=0;i<3;i++)
        {
            if(Character.isLetter(account[i]))
            {
                account[i] = Character.toUpperCase(account[i]);
            }
        }
        account1 = String.valueOf(account);
        return account1;
    }

    public static String getPhone(String phone)
    {
    	Random ran = new Random();
        int rand1 = ran.nextInt(7);
        int rand2 = rand1+2;

        String account2 = phone.substring(rand1,rand2);

        return account2;
    }

    public static char getName(String name)
    {
    	name = name.replace(" ","");
    	System.out.println(name);
    	Random ran = new Random();
        int rand1 = ran.nextInt(3);
        
        char letter = Character.toUpperCase(name.charAt(rand1));

        return letter;       

    }
    public static void main ( String args[] )
    {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString().replace("-",""));

        String name = "Woody Buzz";
        String phone = "7702231231";

        String accountno = "DBS" + getUUID(uuid) + getPhone(phone) + getName(name);    

        System.out.println("Account " + accountno);

    }
}