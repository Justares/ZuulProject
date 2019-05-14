package zuul.commands;

import zuul.Befehl;
import zuul.Casino;

public class CasinoCommand implements CommandFunction {
    private Casino casino;

    public CasinoCommand(Casino casino) {
        this.casino = casino;
    }

    @Override
    public void execute(Befehl befehl) {
    	spielen();
    }
    
    public void spielen() {
    	casino.begrueßung();
    }

    
}
