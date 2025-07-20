package com.poo2.projeto1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author Vitor Emanuel
 *
 */
public class Processor {

	private QueueFifo<String> words;
	private Set<String> data_name_index;
	private Set<String> data_name_value;
	
	public Processor(Input i,Output o) {

		words = new QueueFifo<String>();
		data_name_index = new HashSet<String>();
		data_name_value = new HashSet<String>();

		parse(i.getData());
		create(o);
	}

	private void create(Output o) {
		String lastWord = "";
		Map<String, Integer> pos = new HashMap<String, Integer>();
		List<String> data = new ArrayList<String>();
		while (!words.isEmpty()) {

			if (lastWord.length() == 0) {

				String first = words.pop();
				String second = words.pop();
				data.add(String.format("%s, %s", first, second));

				data_name_index.add(first);
				data_name_value.add(first + second);
				pos.put(first, data.size());


				lastWord = second;
				continue;
			}
			String next = words.pop();
			if (!data_name_index.contains(lastWord)){
					
				pos.put(lastWord, data.size());
				
				data_name_index.add(lastWord);
				data_name_value.add(lastWord + next);
				data.add(String.format("%s, %s", lastWord, next));

			}
			else {

				if ( !data_name_value.contains(lastWord+next)) {
					int index = pos.get(lastWord);
					data.set(index,data.get(index) + ", "+next);
					data_name_value.add(lastWord+next);
				}
		
		
			}
			
			lastWord = next;
		}

		data.sort(null);
	
		o.out(data);
	}

	private void parse(List<String> inputData) {

		for (String string : inputData) {

			for (String s : string.split("\\s+")) {
				words.push(s.trim().toLowerCase().replace(",", "").replace(" ", ""));
			}
		}
		
		if( words.size() < 2)
			
			throw new RuntimeException("need at least two words\n");
		
		
	}

}
