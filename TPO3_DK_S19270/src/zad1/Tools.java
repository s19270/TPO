/**
 *
 *  @author Domański Krzysztof S19270
 *
 */

package zad1;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class Tools {
	static Options createOptionsFromYaml(String fileName){
		try {
			Yaml yaml = new Yaml();
			Map<String, Object> map = yaml.load(new FileReader(fileName));
			String host = (String)map.get("host");
			int port = (int)map.get("port");
			boolean concurMode = (boolean)map.get("concurMode");
			boolean showSendRes = (boolean)map.get("showSendRes");
			Map<String, List<String>> clientsMap  = (Map<String, List<String>>)map.get("clientsMap");
			return new Options(host, port, concurMode, showSendRes, clientsMap);
        } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
