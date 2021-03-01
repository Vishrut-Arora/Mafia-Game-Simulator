
import java.util.*;
import java.util.Comparator;
import java.lang.*;
import java.lang.reflect.Array;
import java.io.*;

abstract class Player {
    final private String type;
    private double hp;
    private final int id;
    private String status = "alive";

    Player(String type, int id) {
        this.type = type;
        this.id = id;
        if (type.equals("mafia")) {
            this.hp = 2500;
        } else if (type.equals("commoner")) {
            this.hp = 1000;
        } else {
            this.hp = 800;
        }
    }

    public String get_type() {
        return this.type;
    }

    public int get_id() {
        return this.id;
    }

    public double get_hp() {
        return this.hp;
    }

    public void set_hp(double val) {
        this.hp = val;
    }

    public void display(int arr[], int new_player_num) {
        Arrays.sort(arr);

        for(int i=0;i<arr.length;i++){
            if(arr[i]==new_player_num){
                System.out.print("Player"+arr[i]+"[User], ");
            }
            else{
            System.out.print("Player"+arr[i]+", ");
        }}
    }  
    public int choose_target(HashMap<Integer,Object> map,Object o,int n,generic gn){
        Random rand = new Random();
        int id=-1;
            List<Integer> list = new ArrayList<>();
            int k=0;
            
            for(int i=1;i<=n;i++){
                if(o!=null &&gn.status(map,i)!=null&& gn.status(map,i).getClass()==o.getClass()){
                    ++k;
                }
                else if(gn.status(map,i)!=null){
                    list.add(i);
                }
            }
            int arr[]=new int[n+1];
            int max=0;
    
            for(int i=0;i<k;i++){ 
                int x=list.get(rand.nextInt(list.size()));
                ++arr[x];
                if(max<arr[x]){
                    max=arr[x];
                    id=x;
                }                
            }
        // else{
        //     id=list.get(rand.nextInt(list.size()));
        // }
    return id;
    }
    // public int vote_out(int n){
    //     return java.util.Random.nextInt(n);
    // }
}
class mafia extends Player{
    private double hp=2500;
    private final int id;
    mafia(int id) {
        super("mafia",id);
        this.id=id;
        // TODO Auto-generated constructor stub
    }

    

}
class detective extends Player{
    private double hp=800;
    private final int id;
    detective(int id) {
        super("detective", id);
        this.id=id;
        // TODO Auto-generated constructor stub
    }
    

}
class healer extends Player{
    final private double healing_power = 500;
    private final int id;
    private double hp=800;
    healer(int id) {
        super("healer", id);
        // TODO Auto-generated constructor stub
        this.id=id;
    }
}
class commoner extends Player{
    private double hp=1000;
    private final int id;
    commoner(int id) {
        super("commoner", id);
        this.id=id;
        // TODO Auto-generated constructor stub
    }

}
class generic{
    public Object status(HashMap<?, ?> map, int src)
    {
        return map.get(src);
    }
    
    public int vote_out(HashMap<Integer,Object> map,int n,int val){
        Random rand=new Random();
        int arr[]=new int[n+1];
        int max=0;
        int index=0;
        int ab=0;
        ++arr[val];
        for(int i=1;i<=n;i++){
            if(status(map,i)!=null){
                ab=0;
                while(status(map,ab)==null){
                    ab=rand.nextInt(n+1);
                }
                ++arr[ab];
                if(arr[ab]>max){
                    max=arr[ab];
                    index=ab;
                }
            }
        }
        return index;
    }
}
public class Mafia_game {
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;
 
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
 
		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
 
		int nextInt() {
			return Integer.parseInt(next());
		}
 
		long nextLong() {
			return Long.parseLong(next());
		}
 
		double nextDouble() {
			return Double.parseDouble(next());
		}
 
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
    }
public static void main(String args[]) throws Exception
{

  FastReader sc = new FastReader();
  Random rand = new Random();
  HashMap<Integer,Object> map =new HashMap<>();
  generic gn =new generic();
  int n=0;
  while(n<6){
  System.out.print("Welcome to Mafia\nEnter the number of players: ");
  n=sc.nextInt();
  if(n<6){
      System.out.println("Sorry, we could not start the game. Please enter a number>=6");
  }
  }
  System.out.println("Choose a Character\n1) Mafia\n2) Detective\n3) Healer\n4) Commoner\n5) Assign Randomly");
  int m=sc.nextInt();
      while(m==0 || m==5){
          m=rand.nextInt(5);
      }
  int new_player_num=0;
  while(new_player_num==0){
      new_player_num=rand.nextInt(n+1);
  }
  int arr[]=new int[n+1];
  //Player pl[]=new Player[n];
  int n1=n/5;
  int n1_extra=n1;
  mafia mf[]=new mafia[n1];
  int n2=n/5;
  int n2_extra=n2;
  detective dt[]=new detective[n2];
  int n3=Math.max(n/10,1);
  int n3_extra=n3;
  healer hl[]=new healer[n3];
  int n4=n-n1-n2-n3;
  int n4_extra=n4;
  commoner cm[]=new commoner[n4];
  int counter=1;
  arr[new_player_num]=1;
  System.out.printf("You are Player%d\n", new_player_num);
  if(m==1){
      System.out.println("You are Mafia. Other Mafias are: ");
      //pl[counter]=new Player("mafia",new_player_num);
      mf[n1-1]=new mafia(new_player_num);
      map.put(new_player_num,mf);
      --n1;
  }
  else if(m==2){
    System.out.println("You are detective. Other detectives are: ");
    //pl[counter]=new Player("detective",new_player_num);
    dt[n2-1]=new detective(new_player_num);
    map.put(new_player_num,dt);
    --n2;
  }
  else if(m==3){
    System.out.println("You are healer. Other healers are: ");
    //pl[counter]=new Player("healer",new_player_num);
    hl[n3-1]=new healer(new_player_num);
    map.put(new_player_num,hl);
    --n3;
  }
  else{
    System.out.println("You are commoner. Other commoners are ");
    //pl[counter]=new Player("commoner",new_player_num);
    cm[n4-1]=new commoner(new_player_num);
    map.put(new_player_num,cm);
    --n4;
  }
  while(n1!=0){
      int x=rand.nextInt(n+1);
      if(arr[x]==0 && x!=0){
          ++arr[x];
          mf[n1-1]=new mafia(x);
          map.put(x,mf);
          --n1;
          if(m==1){
              System.out.println("[Player"+x+"]");
          }
      }
  }
  while(n2!=0){
    int x=rand.nextInt(n+1);
    if(arr[x]==0 && x!=0){
        ++arr[x];
        dt[n2-1]=new detective(x);
        map.put(x,dt);
        --n2;
        if(m==2){
            System.out.println("[Player"+x+"]");
        }        
    }
}
while(n3!=0){
    int x=rand.nextInt(n+1);
    if(arr[x]==0 && x!=0){
        ++arr[x];
        hl[n3-1]=new healer(x);
        map.put(x,hl);
        --n3;
        if(m==3){
            System.out.println("[Player"+x+"]");
        }        
    }
}
for(int i=1;i<=n;i++){
    if(arr[i]==0 && n4!=0){
        ++arr[i];
        cm[n4-1]=new commoner(i);
        map.put(i,cm);
        --n4; 
        if(m==4){
            System.out.println("[Player"+i+"]");
        }               
    }
}
// for(int i=0;i<n;i++){
// System.out.println(pl[i].get_type()+" "+pl[i].get_id());
// }
int total_number_mafias=n/5;
int total_other_players=n-total_number_mafias;
int flag=0;
int count=0;
int got_mafia=0;
while(flag==0&&(total_other_players!=total_number_mafias)&&(total_other_players!=0)&&(total_number_mafias!=0)){
    ++count;
    got_mafia=0;
    System.out.println("\n------------------------------------------------------------\n                   ROUND "+count+"\n------------------------------------------------------------");
    System.out.print((total_other_players+total_number_mafias)+" players are remaining:\n");
    for(int i=1;i<=n;i++){
        if(gn.status(map,i)!=null){
            System.out.print("Player"+i+", ");
        }
    }
    System.out.println("are alive.\n");
    int target=-1;
    int arr_check[]=new int[2];
    int test=-1;
    int heal=-1;
    double total_hp_mafia=0;
    double hp_reduce=0;
    int nmafia=total_number_mafias;
    int flagg=0;    
    /////////////////  mafia    //////////////////////////////////////////////
        if(gn.status(map,new_player_num)!=null && gn.status(map,new_player_num).getClass()==mf.getClass()){
            while(gn.status(map,target)==null || gn.status(map,target).getClass()==mf.getClass()){
            System.out.print("Choose a target: ");
            target=sc.nextInt();
            if(gn.status(map,target)!=null && gn.status(map,target).getClass()==mf.getClass()){
                System.out.println("You cannot choose a mafia");
            }
            else if(gn.status(map,target)==null){
                System.out.println("\nYou cannot choose a player that is already killed");
            }
                       
        }          
        }
        else{
            target=mf[0].choose_target(map,mf, n,gn);
            System.out.println("Mafias have chosen their target.");
        }
if(target!=-1){
        for(int i=1;i<=n;i++){
            if(gn.status(map,i)!=null && gn.status(map, i).getClass()==mf.getClass()){
                for(int j=0;j<n1_extra;j++){
                    if(mf[j].get_id()==i){
                        total_hp_mafia+=mf[j].get_hp();
                    }
                }
            }
        }

        if(gn.status(map, target).getClass()==dt.getClass()){
            for(int i=0;i<n2_extra;i++){
            if(target==dt[i].get_id()){
                if(total_hp_mafia>=dt[i].get_hp()){
                    hp_reduce=dt[i].get_hp();
                    dt[i].set_hp(0);
                }
                else{
                    dt[i].set_hp(dt[i].get_hp()-total_hp_mafia);
                    hp_reduce=total_hp_mafia;
                }
                arr_check[0]=i;
                arr_check[1]=2;

            }
            }
        }
        if(gn.status(map, target).getClass()==hl.getClass()){
            for(int i=0;i<n3_extra;i++){
            if(target==hl[i].get_id()){
                if(total_hp_mafia>=hl[i].get_hp()){
                    hp_reduce=hl[i].get_hp();
                    hl[i].set_hp(0);
                }
                else{
                    hl[i].set_hp(hl[i].get_hp()-total_hp_mafia);
                    hp_reduce=total_hp_mafia;
                }
                arr_check[0]=i;
                arr_check[1]=3;

            }
            }
        }
        if(gn.status(map, target).getClass()==cm.getClass()){
            for(int i=0;i<n4_extra;i++){
            if(target==cm[i].get_id()){
                if(total_hp_mafia>=cm[i].get_hp()){
                    hp_reduce=cm[i].get_hp();
                    cm[i].set_hp(0);
                }
                else{
                    cm[i].set_hp(cm[i].get_hp()-total_hp_mafia);
                    hp_reduce=total_hp_mafia;
                }
                arr_check[0]=i;
                arr_check[1]=4;
            }
            }
        }                 
            while(flagg==0){
                flagg=1;
            for(int i=0;i<n1_extra;i++){
                if(gn.status(map,mf[i].get_id())!=null && gn.status(map,mf[i].get_id()).getClass()==mf.getClass()){
                    if(mf[i].get_hp()!=0 && mf[i].get_hp()<(hp_reduce/(double)nmafia)){
                        --nmafia;
                        hp_reduce-=mf[i].get_hp();
                        mf[i].set_hp(0);
                    }
                }                
            }
        }
        for(int i=0;i<n1_extra;i++){
            if(gn.status(map,mf[i].get_id())!=null&&gn.status(map,mf[i].get_id()).getClass()==mf.getClass()){
                if(mf[i].get_hp()>=(hp_reduce/(double)nmafia)){
                    mf[i].set_hp(mf[i].get_hp()-(hp_reduce/(double)nmafia));
                }
            }
            //System.out.println("----"+mf[i].get_hp());               
        }
    }
//////////////////////////////detectives//////////////////////////////////////
        if(gn.status(map,new_player_num)!=null && gn.status(map,new_player_num).getClass()==dt.getClass()){
            while(gn.status(map,test)==null || gn.status(map,test).getClass()==dt.getClass()){
            System.out.print("Choose a player to test: ");
            test=sc.nextInt();
            if(gn.status(map,test)!=null && gn.status(map,test).getClass()==dt.getClass()){
                System.out.println("\nYou cannot choose a detective");
            }
            else if(gn.status(map,test)==null){
                System.out.println("\nYou cannot choose a player that is already killed");
            }                        
        }
        if(test!=-1 && gn.status(map,test).getClass()==mf.getClass()){
            System.out.println("Player"+test+" is a mafia");
            got_mafia=test;

        }
        else{
            System.out.println("Player"+test+" is not a mafia");
        }           
        }
        else{
            test=dt[0].choose_target(map,dt, n,gn);
            if(test!=-1 && gn.status(map,test).getClass()==mf.getClass()){
                got_mafia=test;
            }           
            System.out.println("Detectives have chosen a player to test.");
        }

/////////////////////////healer///////////////////////////////////////////////        

    if(gn.status(map,new_player_num)!=null&&gn.status(map,new_player_num).getClass()==hl.getClass()){
            while(gn.status(map,heal)==null){
            System.out.print("Choose a player to heal: ");
            heal=sc.nextInt();
            if(gn.status(map,heal)==null){
                System.out.println("\nYou cannot choose a player that is already killed");
            }             
        }   
        }
        else{
            heal=hl[0].choose_target(map,hl, n,gn);
            System.out.println("Healers have chosen someone to heal.");
        }
        if(heal!=-1){
            heal=-1;
            while(gn.status(map,heal)==null){
                heal=rand.nextInt(n+1);
            }
            if(gn.status(map,heal).getClass()==mf.getClass()){
                for(int i=0;i<n1_extra;i++){
                    if(mf[i].get_id()==heal){
                        mf[i].set_hp(mf[i].get_hp()+500);
                    }
                }
            }
            else if(gn.status(map,heal).getClass()==dt.getClass()){
                for(int i=0;i<n2_extra;i++){
                    if(dt[i].get_id()==heal){
                        dt[i].set_hp(dt[i].get_hp()+500);
                    }
                }
            }
            else if(gn.status(map,heal).getClass()==hl.getClass()){
                for(int i=0;i<n3_extra;i++){
                    if(hl[i].get_id()==heal){
                        hl[i].set_hp(hl[i].get_hp()+500);
                    }
                }
            }
            else{
                for(int i=0;i<n4_extra;i++){
                    if(cm[i].get_id()==heal){
                        cm[i].set_hp(cm[i].get_hp()+500);
                    }
                }                
            }

        }
System.out.println("------------------------End of Actions---------------------");        
        if(target!=-1){
        
            if(arr_check[1]==2){
                //System.out.println(dt[arr_check[0]].get_hp());
                if(dt[arr_check[0]].get_hp()==0){
                    map.remove(target);
                    System.out.println("Player"+target+" has died");
                    --total_other_players;
                }
                else{
                    System.out.println("No one died.");
                }
                //dt[arr_check[0]].set_hp(20);
                //System.out.println(dt[arr_check[0]].get_hp());
            }
            else if(arr_check[1]==3){
                //System.out.println(hl[arr_check[0]].get_hp());
                if(hl[arr_check[0]].get_hp()==0){
                    map.remove(target);
                    System.out.println("Player"+target+" has died");
                    --total_other_players;
                }
                else{
                    System.out.println("No one died.");
                }
                // hl[arr_check[0]].set_hp(20);
                // System.out.println(hl[arr_check[0]].get_hp());                

            }
            else{
                //System.out.println(cm[arr_check[0]].get_hp());
                if(cm[arr_check[0]].get_hp()==0){
                    map.remove(target);
                    System.out.println("Player"+target+" has died");
                    --total_other_players;
                }
                else{
                    System.out.println("No one died.");
                }
                // cm[arr_check[0]].set_hp(20);
                // System.out.println(cm[arr_check[0]].get_hp());                                
            }
        }
        if((total_other_players!=total_number_mafias)&&(total_other_players!=0)){
            if(got_mafia!=0){
                System.out.println("Player"+got_mafia+" has been voted out");
                map.remove(got_mafia);
                --total_number_mafias;
            }
        else{           
        int vote_out_player=0;
        if(gn.status(map,new_player_num)!=null){
            int ab=0;
            while(gn.status(map, ab)==null){
            System.out.print("Select a person to vote out: ");
            ab=sc.nextInt();
            if(gn.status(map, ab)==null){
                System.out.println("The player is already out");
            }
            }
            vote_out_player=gn.vote_out(map, n, ab);
            
        }
        else{
            vote_out_player=gn.vote_out(map, n, 0);
        }
        //System.out.println(target+" "+heal);
        if(gn.status(map,vote_out_player).getClass()==mf.getClass()){
            --total_number_mafias;
        }
        else{
            --total_other_players;
        }
        System.out.println("Player"+vote_out_player+" has been voted out");
        map.remove(vote_out_player); 
    }   
    }
    System.out.println("---------------------End of Round "+count+"-------------------------");             
    
}
if((total_number_mafias==0)){
    System.out.println("Game Over.\nThe Mafias have lost.");
}
else{
    System.out.println("Game Over.\nThe Mafias have won.");
}
int arr1[]=new int[n1_extra];
int arr2[]=new int[n2_extra];
int arr3[]=new int[n3_extra];
int arr4[]=new int[n4_extra];
for(int i=0;i<n1_extra;i++){
    arr1[i]=mf[i].get_id();
}
for(int i=0;i<n2_extra;i++){
    arr2[i]=dt[i].get_id();
}
for(int i=0;i<n3_extra;i++){
    arr3[i]=hl[i].get_id();
}
for(int i=0;i<n4_extra;i++){
    arr4[i]=cm[i].get_id();
}
mf[0].display(arr1,new_player_num);
System.out.println(" were mafias");
dt[0].display(arr2,new_player_num);
System.out.println(" were detectives");
hl[0].display(arr3,new_player_num);
System.out.println(" were healer");
cm[0].display(arr4,new_player_num);
System.out.println(" were commoners");
}
}