package com.geekbrains.rpg.game.logic;

public class Weapon {
    // Свойства оружия: дальность атаки, урон, скорость атаки
    private float attackRange;
    private float attackSpeed;
    private float damage;

    private Weaponry arrows;
    private Weaponry blade;

    public Weapon() {

    }

    public enum Weaponry {
        ARROWS, BLADE
    }

    public void toDistributeArrows() {
        arrows = Weaponry.ARROWS;
    }

    public void toDistributeBlade() {
        blade = Weaponry.BLADE;
    }

    public Weaponry getArrows() {
        return arrows;
    }

    public Weaponry getBlade() {
        return blade;
    }
}
