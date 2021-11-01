package source;


public class Trabajo implements Runnable{
	@Override
	public void run() {
		Trabajar();
		
	}
    public void Trabajar()
    {
    	try { Thread.sleep(1000); }
        catch(InterruptedException ex) { ex.printStackTrace(); }
        TrabajarDeNuevo();
    }
	
	public void TrabajarDeNuevo()
	{
		try { Thread.sleep(1000); }
        catch(InterruptedException ex) { ex.printStackTrace(); }
	}
	
	
}
