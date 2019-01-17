package com.dminers.pharmabi.external.domain;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@NodeEntity(label = "Drug")
public class Drug {
    private long id;
    private int nb;
    private @Id String name;

    @Relationship(type = "INTERACTS_WITH", direction = "UNDIRECTED")
    private List<Drug> interactions = new ArrayList<>();

    public Drug() {
    }

    public int getNb() {
        return nb;
    }

    public void setNb(int nb) {
        this.nb = nb;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Drug> getInteractions() {
        return interactions;
    }

    public int getCount() {
        return nb;
    }

    @Override
    public String toString() {
        List<Integer> givenList = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10);
        Random rand = new Random();

        String resultnodes = "{ \"nodes\":[ {\"name\":\"" + name + "\",\"group\":1},";
        for (Drug interaction:interactions) {
            resultnodes = resultnodes.concat("{\"name\":\"" + interaction.name + "\",\"group\":"
                    + givenList.get(rand.nextInt(givenList.size())) + "},");
        }
        resultnodes = resultnodes.substring(0, resultnodes.length() - 1);
        resultnodes += " ]";

        String resultlinks = "\"links\":[ ";
        int j = 0,i = 0;
        for (Drug interaction:interactions) {
            i++;
            resultlinks = resultlinks.concat("{\"source\":0,\"target\":" + i + ", \"value\":1},");
        }
        resultlinks = resultlinks.substring(0, resultlinks.length() - 1);
        resultlinks += " ]";

        return resultnodes + ", " + resultlinks + " }";
    }
}
