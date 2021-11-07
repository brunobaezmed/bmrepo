#include <iostream>
#include <thread>
#include <exception>
const auto MAX_SIZE = 1000;
using namespace std;
template <class type1, class type2>
class RedBlackTree
{

	enum color_t
	{
		BLACK,
		RED
	};

public:
	struct Node
	{

		type1 key;
		type2 value;
		Node *left, *right, *root;
		color_t color = RED;
	};

	RedBlackTree() : root{
					 new Node[MAX_SIZE]},
				  iterator{0}
	{

		for (int i = 0; i < 9; ++i)
		{
			(root + i)->key = 0;

			(root + i)->left = nullptr;
			(root + i)->right = nullptr;
			(root + i)->root = nullptr;
		}
		size = 0;
		Tsz = 9;
	};

	RedBlackTree(int s) : root{
						 new Node[s]},
					  iterator{0}
	{
		for (int i = 0; i < s; ++i)
		{
			(root + i)->key = 0;
			(root + i)->left = nullptr;
			(root + i)->right = nullptr;
			(root + i)->root = nullptr;
		}
		Tsz = s;
		size = 0;
	};

	~RedBlackTree()
	{
		delete[] root;
	}

private:
	int iterator, size;
	Node *root;
	int Tsz;

public:
	void Rezize()
	{
		for (int i = Tsz; i < Tsz * Tsz / 2; ++i)
		{
			(root + i)->key = 0;

			(root + i)->left = nullptr;
			(root + i)->right = nullptr;
			(root + i)->root = nullptr;
		}
		Tsz = Tsz * Tsz / 2;
	};

	void rot_left(Node *p)
	{
		Node *root = Treeroot();
		Node **aux = &root;

		if (p->root != nullptr && p->root->right == p)
			aux = &(p->root->right);
		else if (p->root != nullptr && p->root->left == p)
			aux = &(p->root->left);

		*aux = p->right;
		(*aux)->root = p->root;
		p->root = *aux;
		p->right = (*aux)->left;
		(*aux)->left = p;

		if (p->right != nullptr)
			p->right->root = p;
	}

	void rot_right(Node *p)
	{

		Node *root = Treeroot();
		Node **aux = &root;
		if (p->root != nullptr && p->root->right == p)
			aux = &(p->root->right);
		else if (p->root != nullptr && p->root->left == p)
			aux = &(p->root->left);

		*aux = p->left;
		(*aux)->root = p->root;
		p->root = *aux;
		p->left = (*aux)->right;
		(*aux)->right = p;

		if (p->left != nullptr)
			p->left->root = p;
	}
	Node *grandpha(Node *n)
	{
		if ((n != nullptr) && (n->root != nullptr))
			return n->root->root;
		else
			return nullptr;
	}
	Node *uncle(Node *n)
	{

		Node *g = grandpha(n);
		if (g != nullptr)
		{
			if (n->root == g->left)
				return g->right;
			else
				return g->left;
		}
		else
			return nullptr;
	}

	type2 getValue(Node *tree, type1 key)
	{
		if (tree == nullptr)
			return nullptr;
		if (tree->key == key)
			return tree->value;
		if (tree->key < key)
			return getValue(tree->right, key);
		if (tree->key > key)
			return getValue(tree->left, key);
	}
	void insertNode(Node *n, type1 key, type2 value)
	{

		if (root->key == 0)
		{
			(root)->key = key;
			(root)->value = value;
			++iterator;
			++size;
			return;
		};
		if (n->key == key)
			__throw_invalid_argument("key duplicated");
		if (key > n->key)
		{
			if (n->right == nullptr)
			{
				n->right = (root + iterator);
				(root + iterator)->key = key;
				(root + iterator)->value = value;
				(root + iterator)->root = n;
				++iterator;
				++size;
				return;
			}
			insertNode(n->right, key, value);
		}
		else if (key < n->key)
		{
			if (n->left == nullptr)
			{
				n->left = (root + iterator);
				(root + iterator)->key = key;
				(root + iterator)->value = value;
				(root + iterator)->root = n;
				++iterator;
				++size;
				return;
			}
			insertNode(n->left, key, value);
		}
	}

	void insert(type1 key, type2 value)
	{
		if (this->iterator >= Tsz)
		{
			Rezize();
		}
		Node *Troot = Treeroot();

		insertNode(Troot, key, value);
		Node *n = getNode(Troot, key);
		checkRBT(n);
	}

	void checkRBT(Node *node)
	{
		if (node->root == nullptr)
		{

			node->color = BLACK;
			return;
		}

		if (node->root->color == BLACK)
			return;

		Node *un = uncle(node);
		Node *a = grandpha(node);
		if ((un != nullptr) && (un->color == RED))
		{
			node->root->color = BLACK;
			un->color = BLACK;
			a = grandpha(node);
			a->color = RED;
			checkRBT(a);
			return;
		}
		a = grandpha(node);

		if (a != nullptr)
		{

			if ((node == node->root->right) && (node->root == a->left))
			{
				rot_left(node->root);
				node = getNode(node, node->key);
				node = node->left;
			}
			else if ((node == node->root->left) && (node->root == a->right))
			{
				rot_right(node->root);
				node = getNode(node, node->key);
				node = node->right;
			}
			a = grandpha(node);

			node->root->color = BLACK;
			a->color = RED;
			if ((node == node->root->left) && (node->root == a->left))
			{
				rot_right(a);
			}
			else
			{
				rot_left(a);
			}
		}
	}

	void inorder()
	{
		Node *n = Treeroot();
		inorder(n);
	}
	void postorder()
	{
		Node *n = Treeroot();
		postorder(n);
	}
	Node *Treeroot()
	{
		Node *n = root;
		while (n->root != nullptr)
			n = n->root;
		return n;
	}
	void inorder(Node *n)
	{

		if (n == nullptr)
			return;
		inorder(n->left);
		cout << n->key << " value = " << n->value << " color= ";
		if (n->color == RED)
		{
			cout << "RED";
		}
		else
		{
			cout << "BLACK";
		}
		cout << " root = ";
		if (n->root != nullptr)
		{
			cout << n->root->key << " \n";
		}
		else
		{
			cout << "nullptr\n";
		}
		inorder(n->right);
	}
	void postorder(Node *n)
	{

		if (n == nullptr)
			return;
		cout << n->key << " value = " << n->value << " color= ";
		if (n->color == RED)
		{
			cout << "RED";
		}
		else
		{
			cout << "BLACK";
		}
		cout << " root = ";
		if (n->root != nullptr)
		{
			cout << n->root->key << " \n";
		}
		else
		{
			cout << "nullptr\n";
		}
		postorder(n->left);
		postorder(n->right);
	}

	Node *getNode(Node *n, type1 key)
	{

		if (n->key == key)
		{
			return n;
		}
		if (n->key > key)
		{
			return getNode(n->left, key);
		}
		if (n->key < key)
		{
			return getNode(n->right, key);
		}

		return nullptr;
	}
	int sz() { return size; }

	type1 replace(Node *n, Node *n2)
	{
		type1 key2 = n->key;
		type2 value2 = n->value;

		if (n2->key < key2)
		{

			while (n2->right != nullptr)
			{
				n2 = n2->right;
			}
			key2 = n2->key;
			value2 = n2->value;

			n->key = key2;
			n->value = value2;
			return delete_node(n2);
		}
		else
		{

			while (n2->left != nullptr)
			{
				n2 = n2->left;
			}
			key2 = n2->key;
			value2 = n2->value;

			n->key = key2;
			n->value = value2;
			return delete_node(n2);
		}
	}
	type1 delete_key(type1 key)
	{
		Node *troot = Treeroot();
		color_t swapColor = RED;
		Node *node = getNode(troot, key);
		if (node->left == nullptr && node->right == nullptr && node->color == RED)
		{
			return delete_node(node);
		}
		

		if (node->color == BLACK)
		{
			if (node->left != nullptr && node->left->color == RED && node->right == nullptr)
			{
				delete_node(node);
				return key;
			}
			else if (node->right != nullptr && node->right->color == RED && node->left == nullptr)
			{	delete_node(node);
				return key;
			}
			Node *bro = brother(node);
			Ercase1(node, bro);
			bro = brother(node);
			if (bro->color == BLACK)
			{
				if (node->left == nullptr && node->right == nullptr || bro->left->color == BLACK && bro->right->color == BLACK)
				{
					bro->color = RED;
					if (node->root->color == RED)
					{
						node->root->color == BLACK;
						delete_node(node);
						return key;
					}
					else
					{
						
						return delete_key(key);
					}
				}

				if (bro->left != nullptr && bro->left->color == RED && (bro->right == nullptr || bro->right->color == BLACK))
				{
					color_t swapcolor = bro->left->color;
					bro->left->color = bro->color;
					bro->color = swapColor;
					rot_right(bro);
				}
				if (bro->right->color == RED)
				{
					bro->right->color = BLACK;
					node->root->color = BLACK;
					rot_left(node->root);
					delete_node(node);
					return key;
				}
			}
		}
		
		return key;
	}
	type1 delete_node(Node *n)
	{
		type1 er = n->key;
		Node *r;
		if (n->root == nullptr)
		{
			if (n->left != nullptr || n->right != nullptr)
		{
			if (n->left != nullptr)
				replace(n, n->left);
			else
				replace(n, n->right);
		}
			return er;
		}
		else
		{
			r = n->root;
			if (r->right == n)
			{
				r->right = nullptr;
			}
			else
			{
				r->left = nullptr;
			}
		}
		n->key = 0;
		size--;
		return er;
	}

	Node *brother(Node *n)
	{
		if (n == n->root->right)
			return n->root->left;
		else
			return n->root->right;
	}

	void Ercase1(Node *node, Node *bro)
	{
		color_t swapColor = RED;
		if (bro->color == RED)
		{
			swapColor = node->root->color;
			node->root->color = bro->color;
			bro->color = swapColor;
			rot_left(node->root);
		}
	}
};