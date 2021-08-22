package logica;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarritoTest {

	static ICarrito carrito;
	static ICarrito carrito2;
	static Producto papa;
	static Producto lechuga;
	static Producto ajo;

    public CarritoTest() {
    }

    @BeforeEach
    public void setUpClass() throws Exception {
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    @BeforeAll
    static void setUp() {
        carrito = FactoryCarrito.getCarrito();
        papa = new Producto(25, "papa");
        lechuga = new Producto(10, "lechuga");
        ajo = new Producto(0, "ajo");
    }

    @AfterEach
    public void tearDown() {
        carrito.vaciar();
    }

    
    //obtenerCantidad 
    @Test
    public void testAgregarProductoExistente(){

		carrito.agregarProducto(papa, 20);
		assertEquals(20, carrito.obtenerCantidad("papa"));
		carrito.agregarProducto(papa, 2);
		//deberían haber 22 papas
		assertEquals(22, carrito.obtenerCantidad("papa"));
	}
    
    @Test
    public void testCantidadIgual1(){

  		carrito.agregarProducto(lechuga, 1);
  		carrito.agregarProducto(papa, 2);
  		assertEquals(1, carrito.obtenerCantidad("lechuga"));
  	}
    
    
    @Test
    public void testObtenerCantidadProductoInexistenteEnCarro(){
  		assertEquals(-1, carrito.obtenerCantidad("ajo"));	
  	}
    
    @Test
    public void testAgregarCantidadNegativa(){

		carrito.agregarProducto(papa, -1);
		carrito.agregarProducto(lechuga, 2);
		assertEquals(1, carrito.obtenerCantidad("papa"));
	}
    

   
    
    //obtenerPrecioTotal.

    @Test
    public void testProbarTotal(){

		carrito.agregarProducto(papa, 1);
		carrito.agregarProducto(lechuga, 1);
        
		assertEquals(25+10, (long)carrito.obtenerPrecioTotal());
	}
    
    @Test
    public void testProbarTotalCantidadMayor1(){
		carrito.agregarProducto(papa, 3);
		carrito.agregarProducto(lechuga, 1);
		assertEquals(75+10, (long)carrito.obtenerPrecioTotal());
	}
    
    @Test
    public void ObtenerPrecioTotalCarroVacio(){
        
		assertEquals(0, (long)carrito.obtenerPrecioTotal());
	}
    
    @Test
    public void ObtenerPrecioTotalConP$0(){
    	carrito.agregarProducto(ajo, 10);
		assertEquals(0, (long)carrito.obtenerPrecioTotal());
	}
    
    @Test
    public void ObtenerPrecioTotalP$0yPConCosto(){
    	carrito.agregarProducto(ajo, 2);
    	carrito.agregarProducto(lechuga, 10);
		assertEquals(100, (long)carrito.obtenerPrecioTotal());
	}
    
    
    @Test
    public void testProbarTotalConCantNegativa(){
		carrito.agregarProducto(papa, -1);
		carrito.agregarProducto(lechuga, -1);
		assertEquals(35, (long)carrito.obtenerPrecioTotal());
	}
    
    
    
}