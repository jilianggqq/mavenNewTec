package edu.gqq.json;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import static java.lang.System.out;
public class ListToJson {
	public static void main(String[] args) {
		List<Command> commands = new ArrayList<Command>() {
			{
				add(new Command(1, 2));
				add(new Command(3, "c1", 33, "a", "b", 0));
				add(new Command(2, 3));
				add(new Command(3, 2));
				add(new Command(4, 99));
			}
		};
		Gson g = new Gson();
		Type lstCommandType = new TypeToken<List<Command>>(){}.getType();
		String json = g.toJson(commands, lstCommandType);
//		String json = g.toJson(commands);
		//[{"commandId":1,"uptocloud":2, "name":"c2"},{"commandId":3,"name":"c1","dataLength":33,"paramName1":"a","paramName2":"b","uptocloud":0},{"commandId":2,"uptocloud":3},{"commandId":3,"uptocloud":2},{"commandId":4,"uptocloud":99}]

		out.println(json);
		
		List<Command> commands2 = g.fromJson("[{'commandId':1,'uptocloud':2, 'name':'c2'},{'commandId':3,'name':'c1','dataLength':33,'paramName1':'a','paramName2':'b','uptocloud':0},{'commandId':2,'uptocloud':3, 'name':'peter'},{'commandId':3,'uptocloud':2},{'commandId':4,'uptocloud':99}]", lstCommandType);
		commands2.forEach(x->out.println(x));
	}
}
