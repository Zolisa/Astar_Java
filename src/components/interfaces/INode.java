/*
 * Copyright (c) Multichoice Technical Operations. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Multichoice Technical Operations. ("Confidential Information"). You
 * shall not disclose such Confidential Information and shall use it
 * only in accordance with the terms of the license agreement you
 * entered into with Multichoice Technical Operations.
 *
 * MULTICHOICE MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE
 * SUITABILITY OF THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE IMPLIED WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE, OR NON-INFRINGEMENT. MULTICHOICE
 * SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT
 * OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 */

package components.interfaces;

/**
 * @author Navaneeth Sen
 * @since 2015/08/21
 */

import components.Node;

/**
 * The interface which exposes the features available with a Node
 */
public interface INode
{
    float getHeuristicCost();

    void setHeuristicCost(float heuristicCost);

    float getMovementCostFromStart();

    void setMovementCostFromStart(float movementCost);

    int setParent(Node parent);

    int getX();

    int getY();

    boolean isWalkable();

    String getNodeName();

    char getNodeValue();

    INode getParent();

    float getWeight();

    void setWeight(float weight);

}
