/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Catalogo_CangrejoWeb.CatalogoCangrejoWeb.repositorio;

import Catalogo_CangrejoWeb.CatalogoCangrejoWeb.interfaces.InterfaceSupplement;
import Catalogo_CangrejoWeb.CatalogoCangrejoWeb.modelo.Supplement;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Juan Valero
 */
@Repository
public class SupplementRepository {
    @Autowired
    private InterfaceSupplement userCrudRepository;
    
    
    public List<Supplement> getAll() {
        return userCrudRepository.findAll();
    }
    public Optional<Supplement> getClothe(String reference) {
        return userCrudRepository.findById(reference);
    }
    
    public Supplement create(Supplement clothe) {
        return userCrudRepository.save(clothe);
    }
    public void update(Supplement clothe) {
        userCrudRepository.save(clothe);
    }
    public void delete(Supplement clothe) {
        userCrudRepository.delete(clothe);
    }
}
