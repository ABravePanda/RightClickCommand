package fortune;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
    
    public static Main instance;
    
    @Override
    public void onEnable()
    {
	instance = this;
	registerConfig();
	registerEvents();
    }
    
    
    @Override
    public void onDisable()
    {
        super.onDisable();
    }
    
    private void registerEvents()
    {
	this.getServer().getPluginManager().registerEvents(new Events(this), this);
    } 
    
    private void registerConfig()
    {
	this.saveDefaultConfig();
    }
    
    

}
