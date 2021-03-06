package model.player.type;

import controller.IController;
import model.IGameLogic;
import model.card.type.Color;
import model.card.type.ICard;
/*
 * The human player lets a human play the game
 */
public class HumanPlayer extends AbstractPlayer {

  /*
   * Constructor for HumanPlayer
   * 
   * @param name Name of the player
   */
  public HumanPlayer(String name) {
    super(name);
    // TODO Auto-generated constructor stub
  }

  @Override
  public ICard getCardToPlay(IGameLogic game, IController ctrl) {
    // TODO Auto-generated method stub
    ctrl.updatePlayedCard();
    if (this.needsToDrawCard(game.getCurrentPlayedCard())) {
      ctrl.showMessage(
          game.getCurrentPlayer().toString() + " no tiene cartas para jugar. Debe robar");
      ctrl.showMessage("[AUTODRAW] " + game.getCurrentPlayer().toString() + " roba una carta.");
      int askedIndex = this.getHandSize();
      if (!game.drawOneCard(this).isPlayableOver(game.getCurrentPlayedCard())) {
        askedIndex = -1;
      }
      return this.getCardFromHand(askedIndex);
    }
    int askedIndex = ctrl.AskForCardFromHand(game.getCurrentPlayer());
    if (askedIndex == this.getHandSize()) {
      ctrl.showMessage(game.getCurrentPlayer().toString() + " roba una carta");
      if (!game.drawOneCard(this).isPlayableOver(game.getCurrentPlayedCard())) {
        askedIndex = -1;
      }
    }
    return this.getCardFromHand(askedIndex);
  }

  @Override
  public Color selectColor(IGameLogic game, IController ctrl) {
    // TODO Auto-generated method stub
    return ctrl.askForColor();
  }

}
