package factory;

import organisms.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Валерий on 12.04.2017.
 */
public class Factory {
    private Map<String,AliveOrganismCreator> factoryCreatorMap;
    private Map<String,AliveOrganismFields> factoryFieldsMap;

    public AliveOrganismCreator getFactoryCreator(String id) {
        return factoryCreatorMap.get(id);
    }
    public String[] getFactoryFields(String id, AliveOrganism aliveOrganism){return  factoryFieldsMap.get(id).getFields(aliveOrganism); }

    public Factory(){
        factoryCreatorMap = new HashMap<String,AliveOrganismCreator>();
        factoryFieldsMap = new HashMap<String,AliveOrganismFields>();

        factoryFieldsMap.put("Amanita", new AliveOrganismFields() {
                    @Override
                    public String[] getFields(AliveOrganism aliveOrganism) {
                        String[] fields={"","","",""};
                        Amanita amanita = (Amanita) aliveOrganism;
                        fields[0]= String.valueOf(amanita.getLifeExpectancy());
                        fields[1]=amanita.getDateOfBirds();
                        fields[2]= String.valueOf(amanita.isPoisonous());
                        fields[3]= String.valueOf(amanita.getLengthOfSkirt());
                        return fields;
                    }
                });

        factoryFieldsMap.put("Cat", new AliveOrganismFields() {
            @Override
            public String[] getFields(AliveOrganism aliveOrganism) {
                String[] fields={"","",""};
                Cat cat = (Cat) aliveOrganism;
                fields[0]= String.valueOf(cat.getLifeExpectancy());
                fields[1]=cat.getDateOfBirds();
                fields[2]= String.valueOf(cat.isMammal());
                return fields;
            }
        });

        factoryFieldsMap.put("Chanterelle", new AliveOrganismFields() {
            @Override
            public String[] getFields(AliveOrganism aliveOrganism) {
                String[] fields={"","","",""};
                Chanterelle chanterelle = (Chanterelle) aliveOrganism;
                fields[0]= String.valueOf(chanterelle.getLifeExpectancy());
                fields[1]=chanterelle.getDateOfBirds();
                fields[2]= String.valueOf(chanterelle.isPoisonous());
                fields[3]= String.valueOf(chanterelle.getShadeOfYellow());
                return fields;
            }
        });

        factoryFieldsMap.put("Moss", new AliveOrganismFields() {
            @Override
            public String[] getFields(AliveOrganism aliveOrganism) {
                String[] fields={"","","","",""};
                Moss moss= (Moss) aliveOrganism;
                fields[0]= String.valueOf(moss.getLifeExpectancy());
                fields[1]=moss.getDateOfBirds();
                fields[2]= String.valueOf(moss.isParasite());
                fields[3]= String.valueOf(moss.getMaster());
                return fields;
            }
        });

        factoryFieldsMap.put("Rose", new AliveOrganismFields() {
            @Override
            public String[] getFields(AliveOrganism aliveOrganism) {
                String[] fields={"","","",""};
                Rose rose = (Rose) aliveOrganism;
                fields[0]= String.valueOf(rose.getLifeExpectancy());
                fields[1]=rose.getDateOfBirds();
                fields[2]= String.valueOf(rose.isParasite());
                fields[3]= String.valueOf(rose.getNumberOfSpikes());
                return fields;
            }
        });

        factoryFieldsMap.put("Fish", new AliveOrganismFields() {
            @Override
            public String[] getFields(AliveOrganism aliveOrganism) {
                String[] fields={"","",""};
                Fish fish = (Fish) aliveOrganism;
                fields[0]= String.valueOf(fish.getLifeExpectancy());
                fields[1]=fish.getDateOfBirds();
                fields[2]= String.valueOf(fish.isMammal());
                return fields;
            }
        });

        factoryCreatorMap.put("Amanita", new AliveOrganismCreator() {
                    @Override
                    public AliveOrganism CreateOrganism(int[] numbers) {
                        return new Amanita(numbers[0], String.valueOf(numbers[1]),  numbers[2], numbers[3]);
                    }
                });
        factoryCreatorMap.put("Cat", new AliveOrganismCreator() {
            @Override
            public AliveOrganism CreateOrganism(int[] numbers) {
                return new Cat(numbers[0],String.valueOf(numbers[1]),numbers[2]);
            }
        });
        factoryCreatorMap.put("Chanterelle", new AliveOrganismCreator() {
            @Override
            public AliveOrganism CreateOrganism(int[] numbers) {
                return new Chanterelle(numbers[0],String.valueOf(numbers[1]),numbers[2],numbers[3]);
            }
        });
        factoryCreatorMap.put("Fish", new AliveOrganismCreator() {
            @Override
            public AliveOrganism CreateOrganism(int[] numbers) {
                return new Fish(numbers[0],String.valueOf(numbers[1]),numbers[2]);
            }
        });
        factoryCreatorMap.put("Moss", new AliveOrganismCreator() {
            @Override
            public AliveOrganism CreateOrganism(int[] numbers) {
                return new Moss(numbers[0],String.valueOf(numbers[1]),numbers[2],String.valueOf(numbers[3]));
            }
        });
        factoryCreatorMap.put("Rose", new AliveOrganismCreator() {
            @Override
            public AliveOrganism CreateOrganism(int[] numbers) {
                return new Rose(numbers[0],String.valueOf(numbers[1]),numbers[2],numbers[3]);
            }
        });
        }
    }
