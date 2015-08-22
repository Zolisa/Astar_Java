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

package algorithm.heuristics;

import components.interfaces.INode;

/**
 * @author Navaneeth Sen
 * @since 2015/08/22
 */

/**
 * If the map allows diagonal movements.
 */
public class DiagonalHeuristics implements IHeuristic
{
    public DiagonalHeuristics()
    {
        System.out.println("Using DiagonalHeuristics ...");
    }

    @Override
    public float getHeuristicCost(int srcX, int srcY, INode destinationINode)
    {

        // When D = 1 and D2 = 1, this is called the Chebyshev distance.
        // When D = 1 and D2 = sqrt(2), this is called the Octile distance.
        double D = 1;
        double D2 = Math.sqrt(2);

        double d1 = Math.abs(destinationINode.getX() - srcX);
        double d2 = Math.abs(destinationINode.getY() - srcY);

        return (float) ((D * (d1 + d2)) + ((D2 - (2 * D)) * Math.min(d1, d2)));
    }
}
