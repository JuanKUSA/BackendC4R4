/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Catalogo_CangrejoWeb.CatalogoCangrejoWeb.interfaces;

import Catalogo_CangrejoWeb.CatalogoCangrejoWeb.modelo.Supplement;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Juan Valero
 */
public interface InterfaceSupplement extends MongoRepository <Supplement, String>{
    
}
