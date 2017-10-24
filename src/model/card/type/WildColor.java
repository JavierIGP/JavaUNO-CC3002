package model.card.type;

import controller.IController;
import model.IGameLogic;

public class WildColor extends AbstractCard {

  public WildColor() {
    this.color = Color.NONE;
    this.symbol = Symbol.WILD;

  }

  @Override
  public boolean isPlayableOver(ICard otherCard) {
    return true;
  }

  @Override
  public boolean isFirstPlayable() {
    return false;
  }

  @Override
  public void executeAction(IGameLogic game, IController ctrl) {
    this.setColor(game.getCurrentPlayer().selectColor(game, ctrl));
    ctrl.showMessage("Se juega Wild Color !");

  }

}
