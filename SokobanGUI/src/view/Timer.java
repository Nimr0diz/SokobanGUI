package view;

public class Timer{
	boolean stop;
	Runnable runnable;
	Thread thread;
	public Timer(Runnable runnable)
	{
		stop = true;
		this.runnable = runnable;
		init();
	}
	
	private void init() {
		thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(!stop)
				{
					runnable.run();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
	}

	public void start()
	{
		if(stop)
		{
			stop=false;
			new Thread(thread).start();
		}
	}
	
	public void stop()
	{
		stop=true;
	}

}
