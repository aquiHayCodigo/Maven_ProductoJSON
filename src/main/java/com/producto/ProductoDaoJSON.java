package com.producto;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductoDaoJSON implements ProductoDAOLocal {
    private File fichero;

    public ProductoDaoJSON() {
    }

    public ProductoDaoJSON(String ruta) {
        this.fichero = new File(ruta);
    }

    public void setFichero(File fichero) {
        this.fichero = fichero;
    }

    public File getFile() {
        return fichero;
    }

    @Override
    public void guardarTodos(List<Producto> productos) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(this.fichero, productos);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Producto> listarTodos() {
        List<Producto> productos = new ArrayList<>();
        File file =  new File("listadoLocal.txt");
        ObjectMapper mapper = new ObjectMapper();
        try {
            productos = mapper.readValue(file, new TypeReference<List<Producto>>(){});
        } catch (Exception e) {
        }
        

        return null;
    }

}
