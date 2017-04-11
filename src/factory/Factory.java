package factory;

import organisms.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Валерий on 12.04.2017.
 */
public class Factory {
    private Map<String,AliveOrganismCreator> factoryCreatorMap;

    public AliveOrganismCreator getFactoryCreator(String id) {
        return factoryCreatorMap.get(id);
    }

    public Factory(){
        factoryCreatorMap = new HashMap<String,AliveOrganismCreator>();
        factoryCreatorMap.put("Amanita", new AliveOrganismCreator() {
            @Override
            public AliveOrganism CreateOrganism(int[] numbers) {
                boolean bool;
                    bool = numbers[2]%2==1;
                return new Amanita(numbers[0],String.valueOf(numbers[1]),bool,numbers[3]);
            }
        });
        factoryCreatorMap.put("Cat", new AliveOrganismCreator() {
            @Override
            public AliveOrganism CreateOrganism(int[] numbers) {
                boolean bool;
                bool = numbers[2]%2==1;
                return new Cat(numbers[0],String.valueOf(numbers[1]),bool);
            }
        });
        factoryCreatorMap.put("Chanterelle", new AliveOrganismCreator() {
            @Override
            public AliveOrganism CreateOrganism(int[] numbers) {
                boolean bool;
                bool = numbers[2]%2==1;
                return new Chanterelle(numbers[0],String.valueOf(numbers[1]),bool,numbers[3]);
            }
        });
        factoryCreatorMap.put("Fish", new AliveOrganismCreator() {
            @Override
            public AliveOrganism CreateOrganism(int[] numbers) {
                boolean bool;
                bool = numbers[2]%2==1;
                return new Fish(numbers[0],String.valueOf(numbers[1]),bool);
            }
        });
        factoryCreatorMap.put("Moss", new AliveOrganismCreator() {
            @Override
            public AliveOrganism CreateOrganism(int[] numbers) {
                boolean bool;
                bool = numbers[2]%2==1;
                return new Moss(numbers[0],String.valueOf(numbers[1]),bool,String.valueOf(numbers[3]));
            }
        });
        factoryCreatorMap.put("Rose", new AliveOrganismCreator() {
            @Override
            public AliveOrganism CreateOrganism(int[] numbers) {
                boolean bool;
                bool = numbers[2]%2==1;
                return new Rose(numbers[0],String.valueOf(numbers[1]),bool,numbers[3]);
            }
        });
        }
    }
