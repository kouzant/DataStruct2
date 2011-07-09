package structure;

import entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Iterator;

/**
 * Κλάση που αντιπροσωπεύει ένα κόμβο στο δυαδικό δένδρο αναζήτησης.
 */
class Node{
	//Αριστερός κόμβος-παιδί
	private Node leftNode;
	//Δεξιός κόμβος--παιδί
	private Node rightNode;
	//Τα δεδομένα που κρατάει ο κόμβος
	private Flights data;
	private long MaxArr;
	
	/**
	 * Επιστρέφει τον αριστερό κόμβο-παιδί.
	 * 
	 * @return Τον αριστερό κόμβο-παιδί.
	 */
	public Node getLeftNode(){
		return leftNode;
	}
	/**
	 * Επιστρέφει τον δεξιό κόμβο-παιδί.
	 * 
	 * @return Τον δεξιό κόμβο-παιδί.
	 */
	public Node getRightNode(){
		return rightNode;
	}
	/**
	 * Επιστρέφει τα δεδομένα του κόμβου.
	 * 
	 * @return Τα δεδομένα του κόμβου.
	 */
	public Flights getData(){
		return data;
	}
	/**
	 * Επιστρέφει το field MaxArr.
	 * 
	 * @return Το field MaxArr.
	 */
	public long getMaxArr(){
		return MaxArr;
	}
	/**
	 * Ορίζει τον αριστερό κόμβο-παιδί.
	 *  
	 * @param leftNode Ο αριστερός κόμβος-παιδί.
	 */
	public void setLeftNode(Node leftNode){
		this.leftNode=leftNode;
	}
	/**
	 * Ορίζει τον δεξιό κόμβο-παιδί.
	 * 
	 * @param rightNode Ο δεξιός κόμβος-παιδί.
	 */
	public void setRightNode(Node rightNode){
		this.rightNode=rightNode;
	}
	/**
	 * Ορίζει τα δεδομένα που θα κρατάει ο κόμβος.
	 * 
	 * @param data Τα δεδομένα του κόμβου.
	 */
	public void setData(Flights data){
		this.data=data;
	}
	/**
	 * Ορίζει την τιμή του field MaxArr.
	 * 
	 * @param MaxArr Η τιμή του field MaxArr
	 */
	public void setMaxArr(long MaxArr){
		this.MaxArr=MaxArr;
	}
	/**
	 * Constructor που αρχικοποιεί τα fields.
	 * 
	 * @param data Τα δεδομένα που θα κρατάει ο κόμβος.
	 */
	Node(Flights data){
		this.leftNode=null;
		this.rightNode=null;
		this.data=data;
		this.MaxArr=0L;
	}
	/**
	 * Cοnstructor που δημιουργεί έναν κενό κόμβο.
	 */
	Node(){
		this.leftNode=null;
		this.rightNode=null;
		this.data=null;
		this.MaxArr=0L;
	}
	/**
	 * Constructor που αντιγράφει ένα κόμβο σε ένα καινούργιο.
	 * 
	 * @param node Ο κόμβος που θα αντιγραφεί.
	 */
	Node(Node node){
		this.leftNode=node.getLeftNode();
		this.rightNode=node.getRightNode();
		this.data=node.getData();
		this.MaxArr=node.getMaxArr();
	}
	/**
	 * Βρίσκει τα δεδομένα με την ελάχιστη τιμή.
	 * 
	 * @return Τα δεδομένα με την ελάχιστη τιμή.
	 */
	private Flights minValue(){
		if(leftNode==null)
			return data;
		else return leftNode.minValue();
	}
	/**
	 * Διαγράφει ένα κόμβο από το δένδρο.
	 * 
	 * @param data Τα δεδομένα που θα πρέπει να διαγραφούν από το δένδρο.
	 * @param parent Ο πατέρας του κόμβου που εξετάζεται σε κάθε recursion.
	 * @param travDelPath Η λίστα με τους κόμβους που έχουν γίνει traversed 
	 * μέχρι να βρεθεί ο κόμβος που μας ενδιαφέρει.
	 * @return true αν διαγραφεί επιτυχώς, αλλιώς false.
	 */
	public boolean remove(Flights data, Node parent, SimplyLinkedList<Node> travDelPath){
		//Προσθέτει τον εαυτό του (ο κόμβος) στη λίστα με τους traversed κόμβους
		//μέχρι να βρεθεί αυτός που μας ενδιαφέρει.
		travDelPath.addHead(this);
		//Συγκρίνουμε τα δεδομένα του κόμβου που μας ενδιαφέρει και του τρέχοντα
		//κόμβου που γίνεται το recursion.
		long compareR=data.getDepTime()-this.data.getDepTime();
		//Αν η διαφορά είναι μεγαλύτερη από το μηδέν κοιτάμε στο δεξιό
		//υποδένδρο
		if(compareR>0){
			//Αν ο δεξιός κόμβος δεν είναι null
			if(rightNode!=null)
				//Ξανακαλούμε την ίδια μέθοδο (recursion)
				return rightNode.remove(data, this, travDelPath);
			else
				return false;
		//Αν η διαφορά είναι μικρότερη από το μηδέν κοιτάμε στο αριστερό
		//υποδένδρο
		}else if(compareR<0){
			//Αν ο αριστερός κόμβος δεν είναι null
			if(leftNode!=null)
				//Ξανακαλούμε την ίδια μέθοδο (recursion)
				return leftNode.remove(data, this, travDelPath);
			else
				return false;
		//Αν η διαφορά είναι ίση με το μηδέν, βρίκαμε τον κόμβο που μας
		//ενδιαφέρει
		}else{
			//Αν τα παιδιά του κόμβου δεν είναι null
			if(leftNode!=null && rightNode!=null){
				//Στα δεδομένα του κόμβου προς διαγραφή, βάζουμε τα δεδομένα
				//με την ελάχιστη τιμή
				this.data=rightNode.minValue();
				//Διαγράφουμε τον κόμβο από τον οποίο αντιγράψαμε τα δεδομένα
				//παραπάνω.
				rightNode.remove(this.data, this, travDelPath);
			//Αν ο κόμβος που μας ενδιαφέρει το αριστερό παίδι του πατέρα του
			}else if(parent.leftNode==this){
				//Αν το αριστερό παιδί του κόμβου που μας ενδιαφέρει δεν είναι 
				//null, τότε για αριστερό παιδί του πατέρα βάζουμε αυτό, αλλιώς
				//βάζουμε το δεξιό.
				parent.leftNode=(leftNode!=null)?leftNode:rightNode;
			}else if(parent.rightNode==this){
				parent.rightNode=(leftNode!=null)?leftNode:rightNode;
			}
			return true;
		}
	}
}

/**
 * Κλάση που αντιπροσωπεύει το δυαδικό δένδρο αναζήτησης της εφαρμογής.
 *
 * @param <E> Ο τύπος δεδομένων που θα κρατάει το δυαδικό δένδρο αναζήτησης.
 */
public class BinarySearchTree<E>{
	Node root;
	int size=0;
	Node resultNode=null;
	//Λίστα που κρατάμε τους κόμβους που έχουν γίνει traversed κατά την εισαγωγή
	//ενός νέου κόμβου στο δένδρο.
	SimplyLinkedList<Node> travAddPath;
	//Λίστα με τα αποτελέσματα της αναζήτησης.
	SimplyLinkedList<Flights> periodS;
	//Λίστα που κρατάμε τους κόμβους που έχουν γίνει traversed κατά τη διαγραφή
	//ενός κόμβου από το δένδρο.
	SimplyLinkedList<Node> travDelPath;
	
	/**
	 * Προσθέτει ένα νέο κόμβο στη λίστα.
	 * 
	 * @param data Τα δεδομένα που θα κρατάει ο νέος κόμβος.
	 * @see Node#Node(Flights)
	 * @see Node#setMaxArr(long)
	 * @see Flights#getArrTime()
	 * @see SimplyLinkedList#SimplyLinkedList()
	 * @see	BinarySearchTree#add(Node, Flights)
	 * @see SimplyLinkedList#getLength()
	 * @see SimplyLinkedList#removeHead()
	 * @see Node#getMaxArr()
	 */
	public void add(Flights data){
		//Αν δεν υπάρχει ήδη κόμβος στο δένδρο και τα δεδομένα δεν είναι null
		if(root==null && data!=null){
			//Φτιάχνουμε ένα νέο κόμβο και τον θέτουμε ως ρίζα του δένδρου.
			root=new Node(data);
			//Ορίζουμε το πεδίο MaxArr
			root.setMaxArr(data.getArrTime());
			System.out.println("Value "+data+" inserted at the root");
			size++;
		//Αλλιώς αν τα δεδομένα δεν είναι null
		}else if(data!=null){
			//Δημιουργούμε ένα instance μιας μονά συνδεδεμένης λίστα που
			//τη χρησιμοποιούμε ως stack
			travAddPath=new SimplyLinkedList<Node>();
			root=add(root,data);
			
			//Η ώρα άφιξης του καινούργιου κόμβου
			long curArr=data.getArrTime();
			//Όσο υπάρχουν κόμβοι στη λίστα
			while(travAddPath.getLength()!=0){
				Node index=travAddPath.removeHead();
				long indexMax=index.getMaxArr();
				//Αν το πεδίο MaxArr του καινούργιου κόμβου είναι μεγαλύτερο
				//από το αντίστοιχο πεδίο του κόμβου από τη λίστα, τότε το
				//αντικαθιστούμε.
				if(curArr>indexMax){
					index.setMaxArr(curArr);
				}else{
					break;
				}
			}
		}
	}
	
	/**
	 * Μέθοδος που πραγματοποιεί όλες τις απαραίτητες ενέργειες για να
	 * τοποθετηθεί στη σωστή θέση ένας νέος κόμβος.
	 * 
	 * @param index Ο τρέχων κόμβος - ο κόμβος που κάνει τις συγκρίσεις.
	 * @param data Τα δεδομένα που θα αποθηκεύσει ο νέος κόμβος.
	 * @return Τον τρέχων κόμβο.
	 * @see Node#Node(Node)
	 * @see Node#Node(Flights)
	 * @see SimplyLinkedList#addHead(Object)
	 * @see Node#getData()
	 * @see Flights#getDepTime()
	 * @see Node#getLeftNode()
	 * @see Node#setLeftNode(Node)
	 * @see Node#setMaxArr(long)
	 * @see Node#getRightNode()
	 * @see Node#setRightNode(Node)
	 */
	private Node add(Node index,Flights data){
		Node indexNode=new Node(index);
		//Προσθέτει τον τρέχων κόμβο στη λίστα με τους traversed κόμβους
		travAddPath.addHead(indexNode);
		long compareR=indexNode.getData().getDepTime()-data.getDepTime();
		//Αν η διαφορά είναι μηδέν τότε ο κόμβος υπάρχει ήδη.
		if(compareR==0)
			return indexNode;
		//Αν η διαφορά είναι μεγαλύτερη από το μηδέν
		if(compareR>0){
			//Αν το αριστερό παιδί δεν είναι null
			if(indexNode.getLeftNode()!=null){
				//Καλείται πάλι η ίδια μέθοδος με index node το αριστερό
				//παιδί του τρέχοντα κόμβου
				indexNode.setLeftNode(add(indexNode.getLeftNode(),data));
			//Αν το αριστερό παιδί είναι null
			}else{
				//Δημιουργεί ένα νέο κόμβο και τον ορίζει ως αριστερό παιδί
				indexNode.setLeftNode(new Node(data));
				//Ορίζει το πεδίο MaxArr
				indexNode.getLeftNode().setMaxArr(data.getArrTime());
				System.out.println("Value "+data+" inserted at left child");
				//Αυξάνει το μέγεθος της λίστας
				size++;
			}
		//Αν η διαφορά είναι μικρότερη από το μηδέν, ακολουθείται αντίστοιχη
		//διαδικασία με την παραπάνω.
		}else if(compareR<0){
			if(indexNode.getRightNode()!=null){
				indexNode.setRightNode(add(indexNode.getRightNode(),data));
			}else{
				indexNode.setRightNode(new Node(data));
				//Set MaxArr
				indexNode.getRightNode().setMaxArr(data.getArrTime());
				System.out.println("Value "+data+" inserted at right child");
				size++;
			}
		}
		return indexNode;
	}
	
	//Get the value of a node
	//Maybe I'll delete this method!
	public Flights get(long index){
		if(root==null)
			return null;
		Node indexNode=root;
		long compareR;
		while((compareR=indexNode.getData().getDepTime()-index)!=0){
			if(compareR>0){
				if(indexNode.getLeftNode()!=null){
					indexNode=indexNode.getLeftNode();
					System.out.println("Traversed value is: "+indexNode.getData());
				}else{
					return null;
				}
			}else if(compareR<0){
				if(indexNode.getRightNode()!=null){
					indexNode=indexNode.getRightNode();
					System.out.println("Traversed value is: "+indexNode.getData());
				}else{
					return null;
				}
			}
		}
		return indexNode.getData();
	}
	/**
	 * Δοθέντος μιας ημερομηνίας αναχώρησης βρίσκει σε ποιο κόμβο ανήκει.
	 * 
	 * @param index Η ημερομηνία αναχώρησης προς αναζήτηση.
	 * @return Τον κόμβο στον οποίο ανήκει το index.
	 * @see Node#getData()
	 * @see Flights#getDepTime()
	 * @see Node#getLeftNode()
	 * @see Node#getRightNode()
	 */
	public Node getNode(long index){
		if(root==null)
			return null;
		Node indexNode=root;
		long compareR;
		//Παίρνουμε τη διαφορά της ημερομηνίας αναχώρησης του τρέχοντα κόμβου
		//με την ημερομηνία αναχώρησης που ψάχνουμε
		//Όσο η διαφορά αυτή δεν είναι μηδέν
		while((compareR=indexNode.getData().getDepTime()-index)!=0){
			//Αν η διαφορά είναι μεγαλύτερη από το μηδέν
			if(compareR>0){
				//Αν το αριστερό παιδί δεν είναι null
				if(indexNode.getLeftNode()!=null){
					//Θέτουμε ως τρέχοντα κόμβο το αριστερό παιδί
					indexNode=indexNode.getLeftNode();
					System.out.println("Traversed value is: "+indexNode.getData());
				}else{
					return null;
				}
			//Αν η διαφορά είναι μικρότερη από το μηδέν, ακολουθούμε αντίστοιχη
			//διαδικασία
			}else if(compareR<0){
				if(indexNode.getRightNode()!=null){
					indexNode=indexNode.getRightNode();
					System.out.println("Traversed value is: "+indexNode.getData());
				}else{
					return null;
				}
			}
		}
		return indexNode;
	}
	/**
	 * Διαγράφει ένα κόμβο από τη λίστα.
	 * 
	 * @param data Τα δεδομένα προς διαγραφή.
	 * @return true αν διαγραφεί σωστά, αλλιώς false.
	 * @see SimplyLinkedList#SimplyLinkedList()
	 * @see Node#getData()
	 * @see Flights#getDepTime()
	 * @see Node#Node(Flights)
	 * @see Flights#Flights(String, Date, Date)
	 * @see Node#setLeftNode(Node)
	 * @see Node#remove(Flights, Node, SimplyLinkedList)
	 * @see Node#getLeftNode()
	 * @see BinarySearchTree#getNode(long)
	 * @see Node#getRightNode()
	 * @see Node#getMaxArr()
	 * @see SimplyLinkedList#addHead(Object)
	 * @see SimplyLinkedList#removeHead()
	 * @see SimplyLinkedList#getFirstNode()
	 * @see SNode#getValue()
	 * @see SimplyLinkedList#getLength()
	 * @see Node#setMaxArr(long)
	 */
	public boolean remove(Flights data){
		if(root==null){
			return false;
		}else{
			//Δημιουργούμε μια λίστα που θα κρατάει τους traversed κόμβους
			//μέχρι να φτάσουμε στον κόμβο που μας ενδιαφέρει
			travDelPath=new SimplyLinkedList<Node>();
			//Αν ο κόμβος που μας ενδιαφέρει είναι η ρίζα
			if(root.getData().getDepTime()==data.getDepTime()){
				//Δημιουργούμε ένα κενό κόμβο
				Node dummyNode=new Node(new Flights("",new Date(0),new Date(0)));
				//Ορίζουμε τη ρίζα ως αριστερό παιδί του κενού κόμβου
				dummyNode.setLeftNode(root);
				//Διαγράφουμε τον κόμβο
				boolean removeRes=root.remove(data, dummyNode, travDelPath);
				//Ως ρίζα ορίζουμε το νέο αριστερό κόμβο-παιδί
				root=dummyNode.getLeftNode();
				return removeRes;
			//Αν ο κόμβος που μας ενδιαφέρει δεν είναι η ρίζα
			}else{
				//Βρίσκουμε ποιος κόμβος είναι αυτός που χαρακτηρίζεται από
				//τη συγκεκριμένη ώρα αναχώρησης
				Node delNode=getNode(data.getDepTime());
				long tmpMaxArr=0L;
				long tmpMaxLArr=0L;
				long tmpMaxRArr=0L;
				//Παίρνουμε την τιμή του πεδίου MaxArr των παιδιών του, αν δεν
				//είναι null
				if(delNode.getLeftNode()!=null)
					tmpMaxLArr=delNode.getLeftNode().getMaxArr();
				if(delNode.getRightNode()!=null)
					tmpMaxRArr=delNode.getRightNode().getMaxArr();
				//Παίρνουμε τη μεγαλύτερη τιμή
				tmpMaxArr=(tmpMaxLArr>=tmpMaxRArr)?tmpMaxLArr:tmpMaxRArr;
				
				//Προσθέτουμε στο stack τη ρίζα
				travDelPath.addHead(root);
				//Διαγράφουμε το κόμβο.
				boolean removeRes=root.remove(data, null, travDelPath);
				
				//Παίρνουμε τον πατέρα του κόμβου που μας ενδιαφέρει.
				//Είναι ο δεύτερος κόμβος στο stack
				travDelPath.removeHead();
				Node parentNode=travDelPath.getFirstNode().getValue();
				boolean switchMaxArr=false;
				
				if(tmpMaxArr>parentNode.getMaxArr())
					switchMaxArr=true;
				
				//Αν το tmpMaxArr είναι μεγαλύτερο από το αντίστοιχο πεδίο
				//του πατέρα του, τότε για κάθε ένα κόμβο στο stack
				if(switchMaxArr){
					//Ο πρώτος κόμβος του stack θα έχει πάντα MaxArr
					//μικρότερο του tmpMaxArr, εφόσον το switchMaxArr είναι
					//true
					travDelPath.removeHead().setMaxArr(tmpMaxArr);
					while(travDelPath.getLength()!=0){
						//Αν το αντίστοιχο πεδίο του είναι μικρότερο από
						//το tmpMaxArr το αλλάζουμε.
						Node tmpNode=travDelPath.removeHead();
						if(tmpNode.getMaxArr()<tmpMaxArr)
							tmpNode.setMaxArr(tmpMaxArr);
					}
				}
				
				System.out.println(travDelPath);
				return removeRes;
			}
		}
	}
	/**
	 * Μετατρέπει το δυαδικό δένδρο αναζήτησης σε λίστα σύμφωνα με την
	 * ενδοδιάταξη.
	 * 
	 * @return Το δένδρο σε λίστα.
	 * @see SimplyLinkedList#SimplyLinkedList()
	 * @see BinarySearchTree#treeToList(Node, SimplyLinkedList)
	 */
	public SimplyLinkedList<Flights> toList(){
		//Δημιουργεί μία νέα λίστα
		SimplyLinkedList<Flights> theList=new SimplyLinkedList<Flights>();
		treeToList(root,theList);
		return theList;
	}
	/**
	 * Ενδοδιάταξη για το δυαδικό δένδρο αναζήτησης.
	 * @param indexNode Ο τρέχων κόμβος.
	 * @param theList Η λίστα στην οποία αποθηκεύονται οι κόμβοι του δένδρου.
	 * @see Node#getLeftNode()
	 * @see SimplyLinkedList#addTail(Object)
	 * @see Node#getData()
	 * @see Node#getRightNode()
	 */
	private void treeToList(Node indexNode, SimplyLinkedList<Flights> theList){
		//Αν ο κόμβος δεν είναι null
		if(indexNode!=null){
			System.out.println("IndexNode: "+indexNode.getData().getFlightCode());
			System.out.println("MaxArr: "+new Date(indexNode.getMaxArr()));
			//Αναδρομικό κάλεσμα της ίδιας μεθόδου
			treeToList(indexNode.getLeftNode(), theList);
			//System.out.println("Left Node");
			//Προσθέτει τον κόμβο στο τέλος της λίστας.
			theList.addTail(indexNode.getData());
			treeToList(indexNode.getRightNode(), theList);
			//System.out.println("Right Node");
		}
	}
	/**
	 * Κάνει αναζήτηση σε ένα δυαδικό δένδρο αναζήτησης σύμφωνα με τον
	 * κωδικό πτήσης.
	 * @param indexNode Ο τρέχων κόμβος.
	 * @param flightCode Ο κωδικός πτήσης.
	 */
	public void searchNode(Node indexNode, String flightCode){
		//Αν ο τρέχων κόμβος δεν είναι null
		if(indexNode!=null){
			//Αν ο κωδικός πτήσης του τρέχοντα κόμβου είναι ίδιος με τον
			//κωδικό πτήσης που ψάχνουμε
			if(indexNode.getData().getFlightCode().equals(flightCode))
				//Στο field resultNode βάζουμε τον τρέχοντα κόμβο
				resultNode=indexNode;
			//Αναδρομικό κάλεσμα της μεθόδου
			searchNode(indexNode.getLeftNode(), flightCode);
			searchNode(indexNode.getRightNode(), flightCode);
		}
	}
	public void delFlight(String flightCode){
		searchNode(root,flightCode);
		Flights delFlight=resultNode.getData();
		remove(delFlight);
	}
	public SimplyLinkedList<Flights> searchPeriod(Date startTime, Date finishTime){
		periodS=new SimplyLinkedList<Flights>();
		searchPeriodDep(root, startTime, finishTime);
		searchPeriodArr(root, startTime, finishTime);
		
		return periodS;
	}
	
//	public Flight searchAfter(Date timestamp){
//		long time=timestamp.getTime();
//	}
	
	private void searchAfter(Node indexNode, long time){
		if(indexNode!=null){
			Node leftNode=indexNode.getLeftNode();
			Node rightNode=indexNode.getRightNode();
			long leftDep=leftNode.getData().getDepTime();
			long rightDep=rightNode.getData().getDepTime();
			
			if(leftDep<time && rightDep<time){
				//Check both children
				searchAfter(leftNode, time);
				searchAfter(rightNode, time);
			}else if(leftDep<time && rightDep>time){
				//Check only left child
				searchAfter(leftNode, time);
			}else if(leftDep>time && rightDep<time){
				//Check only right child
				searchAfter(rightNode, time);
			}
		}
	}
	private void searchPeriodDep(Node indexNode, Date startTime, Date finishTime){
		if(indexNode!=null){
			System.err.println(indexNode.getData().getFlightCode());
			long indexDep=indexNode.getData().getDepartureTime().getTime();
			if(indexDep>=startTime.getTime() && indexDep<=finishTime.getTime()){
				//Departure Time between given period
				periodS.addTail(indexNode.getData());
			}
			
			if(indexDep>=finishTime.getTime()){
				searchPeriodDep(indexNode.getLeftNode(), startTime, finishTime);
			}else if(indexDep<finishTime.getTime() && indexDep>=startTime.getTime()){
				searchPeriodDep(indexNode.getLeftNode(), startTime, finishTime);
				searchPeriodDep(indexNode.getRightNode(), startTime, finishTime);
			}
		}
	}
	private void searchPeriodArr(Node indexNode, Date startTime, Date finishTime){
		if(indexNode!=null){
			float indexArr=indexNode.getData().getArrivalTime().getTime();
			if(indexArr>=startTime.getTime() && indexArr<=finishTime.getTime()){
				if(!periodS.contains(indexNode.getData()))
					periodS.addTail(indexNode.getData());
			}
			searchPeriodArr(indexNode.getLeftNode(), startTime, finishTime);
			searchPeriodArr(indexNode.getRightNode(), startTime, finishTime);
		}
	}
	
	@Override
	public String toString(){
		SimplyLinkedList<Flights> theList=toList();
		StringBuilder listBuild=new StringBuilder();
		listBuild.append(theList);
		
		return listBuild.toString();
	}
}
