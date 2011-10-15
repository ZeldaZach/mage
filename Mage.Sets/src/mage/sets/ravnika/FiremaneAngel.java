/*
 *  Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without modification, are
 *  permitted provided that the following conditions are met:
 *
 *     1. Redistributions of source code must retain the above copyright notice, this list of
 *        conditions and the following disclaimer.
 *
 *     2. Redistributions in binary form must reproduce the above copyright notice, this list
 *        of conditions and the following disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 *  FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *  The views and conclusions contained in the software and documentation are those of the
 *  authors and should not be interpreted as representing official policies, either expressed
 *  or implied, of BetaSteward_at_googlemail.com.
 */
package mage.sets.ravnika;

import java.util.UUID;

import mage.Constants;
import mage.Constants.CardType;
import mage.Constants.Rarity;
import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.common.BeginningOfUpkeepTriggeredAbility;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.costs.common.OnlyDuringUpkeepCost;
import mage.abilities.costs.mana.ManaCostsImpl;
import mage.abilities.effects.common.GainLifeEffect;
import mage.abilities.effects.common.ReturnSourceFromGraveyardToBattlefieldEffect;
import mage.abilities.keyword.FlyingAbility;
import mage.abilities.keyword.FirstStrikeAbility;
import mage.cards.CardImpl;

/**
 *
 * @author Loki
 */
public class FiremaneAngel extends CardImpl<FiremaneAngel> {

    public FiremaneAngel(UUID ownerId) {
        super(ownerId, 205, "Firemane Angel", Rarity.RARE, new CardType[]{CardType.CREATURE}, "{3}{R}{W}{W}");
        this.expansionSetCode = "RAV";
        this.subtype.add("Angel");

        this.color.setRed(true);
        this.color.setWhite(true);
        this.power = new MageInt(4);
        this.toughness = new MageInt(3);

        this.addAbility(FlyingAbility.getInstance());
        this.addAbility(FirstStrikeAbility.getInstance());
        // At the beginning of your upkeep, if Firemane Angel is in your graveyard or on the battlefield, you may gain 1 life.
        this.addAbility(new BeginningOfUpkeepTriggeredAbility(new GainLifeEffect(1), Constants.TargetController.YOU, true));
        this.addAbility(new BeginningOfUpkeepTriggeredAbility(Constants.Zone.GRAVEYARD, new GainLifeEffect(1), Constants.TargetController.YOU, true));
        // {6}{R}{R}{W}{W}: Return Firemane Angel from your graveyard to the battlefield. Activate this ability only during your upkeep.
        Ability ability = new SimpleActivatedAbility(Constants.Zone.GRAVEYARD, new ReturnSourceFromGraveyardToBattlefieldEffect(), new ManaCostsImpl("{6}{R}{R}{W}{W}"));
        ability.addCost(new OnlyDuringUpkeepCost());
        this.addAbility(ability);
    }

    public FiremaneAngel(final FiremaneAngel card) {
        super(card);
    }

    @Override
    public FiremaneAngel copy() {
        return new FiremaneAngel(this);
    }
}
