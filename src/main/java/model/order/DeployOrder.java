package model.order;

import model.Country;
import model.Player;

/**
 * Class DeployOrder which is a child of Order, used to execute the orders
 *
 * @author Prathika Suvarna
 * @author Neona Pinto
 * @author Dhananjay Narayan
 * @author Surya Manian
 * @author Madhuvanthi Hemanathan
 * @version 1.0.0
 */
public class DeployOrder extends Order {
    /**
     * Constructor for class DeployOrder
     */
    public DeployOrder() {
        super();
        setType("deploy");
    }

    /**
     * Overriding the execute function for the order type deploy
     *
     * @return true if the execution was successful else return false
     */
    public boolean execute() {
        Player l_Player = getOrderInfo().getPlayer();
        String l_Destination = getOrderInfo().getDestination();
        int l_ArmiesToDeploy = getOrderInfo().getNumberOfArmy();
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("The order: " + getType() + " " + getOrderInfo().getDestination() + " " + getOrderInfo().getNumberOfArmy());
        if(validateCommand()){
            for(Country l_Country : l_Player.getCapturedCountries()){
                if(l_Country.getName().equals(l_Destination)){
                    l_Country.deployArmies(l_ArmiesToDeploy);
                }
            }
            return true;
        }
        return false;
    }

    /**
     * A function to validate the commands
     *
     * @return true if command can be executed else false
     */
    public boolean validateCommand(){
        Player l_Player = getOrderInfo().getPlayer();
        String l_Destination = getOrderInfo().getDestination();
        int l_Reinforcements = getOrderInfo().getNumberOfArmy();
        if (l_Player == null || l_Destination == null) {
            System.out.println("Fail to execute Deploy order: Invalid order information.");
            return false;
        }
        if (!l_Player.checkIfCountryExists(l_Destination,l_Player)) {
            System.out.println("The country does not belong to you");
            return false;
        }
        if (!l_Player.deployReinforcementArmiesFromPlayer(l_Reinforcements)) {
            System.out.println("You do not have enough Reinforcement Armies to deploy.");
            return false;
        }
        return  true;
    }

    /**
     * A function to print the order on completion
     */
    public void printOrderCommand(){
        System.out.println("Deployed " + getOrderInfo().getNumberOfArmy() + " armies to " + getOrderInfo().getDestination() + ".");
        System.out.println("---------------------------------------------------------------------------------------------");
    }

}
