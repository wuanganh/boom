package components.entities.dynamics.character.player;

import components.actions.attack.Attack;
import components.actions.attack.AttackAction;
import components.actions.attack.controlled.ControlledBombPlacing;
import components.actions.move.KeyboardBasedMove;
import components.actions.pickup.PickUp;
import components.actions.pickup.PickUpAction;
import components.actions.pickup.nonstop.ItemPickUp;
import components.entities.dynamics.character.Character;
import components.entities.statics.bombs.Bomb;
import components.entities.statics.bombs.children.BombB;
import config.PlayerConfig;
import core.Router;

public abstract class Player extends Character
{
    protected Bomb bomb;

    protected Attack attack;

    protected PickUp pickUp;

    public Player(float x, float y)
    {
        super();

        this.x = x;
        this.y = y;
    }

    @Override
    public void setHealth(int health)
    {
        super.setHealth(health);

        if (health <= 0) {
            Router.getInstance().redirect("GameOverMenu", false);
        }
    }

    @Override
    protected void setEntityParameters()
    {
        width = PlayerConfig.WIDTH;
        height =  PlayerConfig.HEIGHT;
        speed = PlayerConfig.SPEED;
        health = PlayerConfig.HEALTH;
        life = PlayerConfig.HEALTH;

        bomb = new BombB();
        bomb.getExplosion().setTargets(new String[] {
            "Player",
            "Monster",
            "Block",
        });
    }

    @Override
    protected void initializeActions()
    {
        super.initializeActions();

        attack = new AttackAction(this);
        attack = new ControlledBombPlacing(attack, bomb);

        pickUp = new PickUpAction(this);
        pickUp = new ItemPickUp(pickUp);

        move = new KeyboardBasedMove(this);
    }

    @Override
    public void tick()
    {
        super.tick();

        attack.attack();

        pickUp.pickUp();
    }

    public Bomb getBomb()
    {
        return bomb;
    }

    public void setBomb(Bomb bomb)
    {
        this.bomb = bomb;
    }
}
