/*
 * C++ solution for the squirrel hops problem.
 *
 * see the python solution for more comments.  The wooded area forms
 * a graph where the trees are nodes and edges mean that a squirrel
 * could hop between the two nodes.  Determining a forest means
 * figuring out the all-pairs shortest path, for which we use
 * Floyd-Warshall.
 *
 */

#include <iostream>
#include <vector>
#include <map>
#include <string>
#include <utility>

bool is_forest(std::vector<int> &verts, 
	       std::map<int, std::vector<int> > &graph,
	       int H);

int main(void) {
	int P, H, v1, v2;
	std::map<int, std::vector<int> > graph;
	std::vector<int> verts;
	
	while (std::cin >> P >> H) {
		if (!P && !H)
			break;

		graph.clear();
		verts.resize(0);
		
		for (int i = 0; i < P; i++) {
			std::cin >> v1 >> v2;
			graph[v1].push_back(v2);
			graph[v2].push_back(v1);
		}

		std::map<int, std::vector<int> >::iterator cur;

		for (cur = graph.begin(); cur != graph.end(); ++cur) {
			verts.push_back(cur -> first);

/*			
			std::cout << cur -> first << ": ";
			for (int i = 0; i < cur -> second.size(); ++i) {
				std::cout << cur -> second[i] << " ";
			}
			std::cout << std::endl;
*/
		}

		if (is_forest(verts, graph, H))
			std::cout << "yes" << std::endl;
		else
			std::cout << "no" << std::endl;
	}
	
	return 0;
}

bool is_forest(std::vector<int> &verts, 
	       std::map<int, std::vector<int> > &graph,
	       int H)
{
	const int max_dist = 10000000;
	std::map<std::pair<int, int>, int> dist;
	std::map<std::pair<int, int>, int>::iterator d_cur;
	std::map<int, std::vector<int> >::iterator cur;
	int i, j, k, v1, v2, v3;
	std::pair<int, int> edge, edge_ij, edge_ik, edge_kj;
	
	for (i = 0; i < verts.size(); i++) {
		for (j = 0; j < verts.size(); j++) {
			v1 = verts[i];
			v2 = verts[j];
			edge = std::make_pair(v1, v2);

			if (v1 == v2)
				dist[edge] = 0;
			else 
				dist[edge] = max_dist;
		}
	}

	for(cur = graph.begin(); cur != graph.end(); ++cur) {
		v1 = cur -> first;
		for (i = 0; i < cur -> second.size(); i++) {
			// note: only doing this 1 per edge.  v1 -> v2 = 1, but
			// v2 -> v1 also = 1.  we'll catch the v2 -> v1 edge
			// later when we get to the graph row with v2.
			v2 = cur -> second[i];
			edge = std::make_pair(v1, v2);
			dist[edge] = 1;
		}
	}

	for (k = 0; k < verts.size(); k++) {
		v3 = verts[k];
		
		for (i = 0; i < verts.size(); i++) {
			v1 = verts[i];
			edge_ik = std::make_pair(v1, v3);
			
			for (j = 0; j < verts.size(); j++) {
				v2 = verts[j];
				edge_ij = std::make_pair(v1, v2);
				edge_kj = std::make_pair(v2, v3);
				
				if (dist[edge_ij] > dist[edge_ik] + dist[edge_kj])
					dist[edge_ij] = dist[edge_ik] + dist[edge_kj];
			}
		}
	}

	for (d_cur = dist.begin(); d_cur != dist.end(); ++d_cur) {
		if (d_cur -> second < max_dist
		    && d_cur -> second >= H)
			return true;
	}




	return false;
}
