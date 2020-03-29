package sa.site.lab.petstore.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sa.site.lab.petstore.domain.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AnimalDaoDatabaseImpl implements AnimalDao {

    @Autowired
    private  AnimalRepository repository;

    // TODO: Must to implemet
    @Override
    public Animal findById(int id) {
        System.out.println("* AnimalDaoDatabaseImpl.findPet: "+id);
        Optional<Animal> result =repository.findById(id);
     if(result.isPresent()){
         return result.get();
     }else {
         return null;
     }
    }
    // TODO: Must to implemet
    @Override
    public List<Animal> findAll() {
        System.out.println("* AnimalDaoDatabaseImpl.findAll() " );
        Iterable<Animal> result = repository.findAll();

        List <Animal> animals= new ArrayList<>();

        for(Animal animal: result){
        animals.add(animal);
        }
        return animals;
        //throw new RuntimeException("Dao not available yet");

    }
    // TODO: Must to implemet
    @Override
    public void add(Animal animal) {

        System.out.println("* AnimalDaoDatabaseImpl.add() " );
        repository.save(animal);


        //  use Spring Data Repo to access the Animal TABLE

    }

    public boolean delete(int id){
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
