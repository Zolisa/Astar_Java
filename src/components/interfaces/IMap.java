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

import components.Node;

import java.util.ArrayList;

/**
 * @author Navaneeth Sen
 * @since 2015/08/22
 */

public interface IMap
{
    void printMap(ArrayList<ArrayList<Node>> map);

    int getMapWidth();

    int getMapHeight();

    ArrayList<ArrayList<Node>> getMap();

    Node getNodeAtPosition(int x, int y);

    float getDistanceBetween(Node node1, Node node2);

    INode getStartNode();

    INode getEndNode();
}
