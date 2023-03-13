package lab2.Task14;

public class Main14 {
    public static void main(String[] args) {
        Network myFace = new Network();
        Network.Member fred = myFace.enroll("Fred");
        Network.Member alice = myFace.enroll("Alice");

        alice.leave();
        fred.leave();
    }

}
/*
C:\Users\egast\.jdks\openjdk-19.0.2\bin>javap C:\Users\egast\IdeaProjects\lab2\target\classes\lab2\Task14\Network$Member.class
Compiled from "Network.java"
public class lab2.Task14.Network$Member {
  final lab2.Task14.Network this$0;
  public lab2.Task14.Network$Member(lab2.Task14.Network, java.lang.String);
  public void leave();
  public boolean belongsTo(lab2.Task14.Network);
}

C:\Users\egast\.jdks\openjdk-19.0.2\bin>javap -private C:\Users\egast\IdeaProjects\lab2\target\classes\lab2\Task14\Network$Member.class
Compiled from "Network.java"
public class lab2.Task14.Network$Member {
  private final java.lang.String name;
  private final java.util.List<lab2.Task14.Network$Member> friends;
  final lab2.Task14.Network this$0;
  public lab2.Task14.Network$Member(lab2.Task14.Network, java.lang.String);
  public void leave();
  public boolean belongsTo(lab2.Task14.Network);
}
*/