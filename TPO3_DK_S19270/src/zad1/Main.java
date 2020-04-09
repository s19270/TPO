/**
 *
 *  @author Domański Krzysztof S19270
 *
 */

package zad1;


public class Main {

  public static void main(String[] args) throws Exception {
    String fileName = System.getProperty("user.home") + "/PassTimeOptions.yaml";
    //Options opts = Tools.createOptionsFromYaml(fileName);
    System.out.println(Time.passed("2020-03-28T10:00", "2020-03-29T10:00"));
    //System.out.println(opts);
    /*
    opts.getClientsMap().forEach( (id, dates) -> {
      System.out.println(id);
      dates.forEach( dpair -> {
        String[] d = dpair.split(" +");
        String info = Time.passed(d[0], d[1]);
        System.out.println(info);
      });
    });*/
  }

}
