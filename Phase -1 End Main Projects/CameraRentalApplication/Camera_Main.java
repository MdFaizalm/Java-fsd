package CameraRental;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Camera_Main {
	


    public static void main(String[] args) {
       // ADDING CAMERAS IN THE ARRAY LIST
    	currentUser = null;
        cameraList = new ArrayList<>();
        cameraList.add(new Camera(1, "CHROMA", "CT", 500.0, false));
        cameraList.add(new Camera(2, "LG","L123", 500.0, false));
        cameraList.add(new Camera(3, "CANON", "XPL", 25000.0, false));
        cameraList.add(new Camera(4, "SONY", "SONY123", 200.0, false));
        cameraList.add(new Camera(5, "NIKON", "D7500", 500.0, false));
        cameraList.add(new Camera(6, "SAMSUNG", "DS123", 500.0, false));
      // WELCOME PAGE
        System.out.println("\n+----------------------------------+");
        System.out.println("|   WELCOME TO CAMERA RENTAL APP   |");
    	System.out.println("+----------------------------------+\n");
        System.out.println("  PLEASE LOGIN TO CONTINUE    ");
        System.out.println();
    
        loginPage();
        showMainMenu();
    }
    
    
    
    private static User_details currentUser;
    private static List<Camera> cameraList;

  
    private static void loginPage() {
        Scanner sc = new Scanner(System.in);
        String username;
        String password;

        do {
            System.out.print(" USERNAME : ");
            username = sc.nextLine();
            System.out.print(" PASSWORD : ");
            password = sc.nextLine();
        } while (!Valid_Login(username, password));

        System.out.println(" ( Loged in Successfully. )");
    }

    private static boolean Valid_Login(String username, String password) {
        if (username.equals("admin") && password.equals("admin123")) {
        	currentUser = new User_details(username, password);
        	return true;
        } 
        else {
        	System.out.println("\nInvalid username or password. Please try again.\n  !");
        	return false;
        }
    }
    private static void showMainMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
        	System.out.println("\n1. MY CAMERA");
            System.out.println("2. RENT A CAMERA");
            System.out.println("3. VIEW ALL CAMERAS");
            System.out.println("4. MY WALLET");
            System.out.println("5. EXIT");
            System.out.print("  Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    CameraMenu();
                    break;
                case 2:
                    renting_Camera();
                    break;
                case 3:
                    viewAllCameras();
                    break;
                case 4:
                     WalletMenu();
                    break;
                case 5:
                    System.out.println(" ( Thank you for using the Camera Rental App. Exiting... ) ");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again. !");
            }
        } while (true);
    }

    private static void CameraMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. ADD");
            System.out.println("2. REMOVE");
            System.out.println("3. VIEW MY CAMERAS");
            System.out.println("4. GO TO PREVIOUS MENU");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    add_Camera();
                    break;
                case 2:
                    remove_Camera();
                    break;
                case 3:
                    view_My_Cameras();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (true);
    }

    private static void add_Camera() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\n ENTER THE CAMERA BRAND : ");
        String brand = scanner.nextLine();
        System.out.print(" ENTER THE MODEL: ");
        String model = scanner.nextLine();
        System.out.print(" ENTER THE PER DAY PRICE(INR): ");
        double rentalPrice = scanner.nextDouble();

        int nextId = cameraList.size() + 1;
        Camera camera = new Camera(nextId, brand, model, rentalPrice, false);
        cameraList.add(camera);

        System.out.println("YOUR CAMERA HAS BEEN SUCCESSFULLY ADDED TO THE LIST.");
    }

    private static void remove_Camera() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===============================================================================");
        System.out.println("CAMERA ID\tBRAND\t\tMODEL\t\tPRICE(PER DAY)\tSTATUS");
        System.out.println("===============================================================================");
        for (Camera camera : cameraList) {
            System.out.println(camera.getId() + "\t\t" + 
                               camera.getBrand() + "\t\t" +
                               camera.getModel() + "\t\t" + 
                               camera.getRentalPrice() + "\t\t" +
                              (camera.isRented() ? "Rented" : "Available"));
        }
        System.out.println("===============================================================================");
        System.out.print("\nENTER THE CAMERA ID TO REMOVE: ");
        int cameraID=scanner.nextInt();
		scanner.nextLine();
		boolean removed = false;
		for(Camera camera: cameraList) {
			if(camera.getId()==cameraID) {
				cameraList.remove(camera);
				removed = true;
				break;
			}
		}
		if(removed) {
			System.out.println("CAMERA SUCCESSFULLY REMOVED FROM THE LIST.");
		}
		else {
			System.out.println("CAMERA NOT FOUND.");
		}
	}

    private static void view_My_Cameras() {
        List<Camera> cameraList = currentUser.getCameraList();

        System.out.println("\nMY CAMERAS");
        System.out.println("===============================================================================");
        System.out.println("CAMERA ID\tBRAND\t\tMODEL\t\tPRICE(PER DAY)\tSTATUS");
        System.out.println("===============================================================================");

        boolean foundRentedCamera = false;
        for (Camera camera : cameraList) {
            if (camera.isRented()) {
                System.out.println(camera.getId()+ "\t\t" + 
                                   camera.getBrand()+ "\t\t" + 
                		           camera.getModel()+ "\t\t" +
                                  (camera.getRentalPrice()+ "\t\t" + "Rented"));
                foundRentedCamera = true;
            }
        }

        if (!foundRentedCamera) {
            System.out.println("No rented cameras found.");
        }

        System.out.println("===============================================================================");
    }
    private static void renting_Camera() {
    	
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nFollowing is the list of available cameras");
        System.out.println("===============================================================================");
        System.out.println("CAMERA ID\tBRAND\t\tMODEL\t\tPRICE(PER DAY)\tSTATUS");
        System.out.println("===============================================================================");
        for (Camera camera : cameraList) {
            if (!camera.isRented()) {
                System.out.println(camera.getId() + "\t\t" + 
                                   camera.getBrand() + "\t\t" +
                                   camera.getModel() + "\t\t" + 
                                   camera.getRentalPrice() + "\t\t" +
                                  (camera.isRented() ? "Rented" : "Available"));
            }
        }
        System.out.println("===============================================================================");

        System.out.print("\nENTER THE CAMERA ID YOU WANT TO RENT: ");
        int cameraId = scanner.nextInt();

        Camera selectedCamera = null;
        for (Camera camera : cameraList) {
            if (camera.getId() == cameraId) {
                selectedCamera = camera;
                break;
            }
        }

        if (selectedCamera != null && !selectedCamera.isRented()) {
            if (currentUser.getWalletBalance() >= selectedCamera.getRentalPrice()) {
                selectedCamera.setRented(true);
                currentUser.getCameraList().add(selectedCamera);
                currentUser.depositToWallet(-selectedCamera.getRentalPrice());
                System.out.println("YOUR TRANSACTION FOR CAMERA - " + selectedCamera.getBrand() +
                        " " + selectedCamera.getModel() + " with rent INR." +
                        selectedCamera.getRentalPrice() + " HAS SUCCESSFULLY COMPLETED.");
            } else {
                System.out.println("ERROR: TRANSACTION FAILED DUE TO INSUFFICIENT WALLET BALANCE. " +
                        "PLEASE DEPOSIT THE AMOUNT TO YOUR WALLET.");
            }
        } else {
            System.out.println("ERROR: INVALID CAMERA ID OR CAMERA IS ALREADY RENTED.");
        }
    }

    private static void viewAllCameras() {
    	System.out.println("===============================================================================");
        System.out.println("CAMERA ID\tBRAND\t\tMODEL\t\tPRICE(PER DAY)\tSTATUS");
        System.out.println("===============================================================================");
        for (Camera camera : cameraList) {
            System.out.println(camera.getId() + "\t\t" + 
                               camera.getBrand() + "\t\t" +
                               camera.getModel() + "\t\t" + 
                               camera.getRentalPrice() + "\t\t" +
                              (camera.isRented() ? "Rented" : "Available"));
        }
        System.out.println("===============================================================================");
    }

    private static void WalletMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nOUR CURRENT WALLET BALANCE IS INR." + currentUser.getWalletBalance());
        System.out.print("DO YOU WANT TO DEPOSIT MORE AMOUNT TO YOUR WALLET? (1.YES 2.NO): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("ENTER THE AMOUNT (INR): ");
                double amount = scanner.nextDouble();
                currentUser.depositToWallet(amount);
                System.out.println("YOUR WALLET BALANCE UPDATED SUCCESSFULLY. CURRENT WALLET BALANCE - INR." +
                        currentUser.getWalletBalance());
                break;
            case 2:
                break;
            default:
                System.out.println("Invalid choice. Going back to previous menu.");
                break;
        }
    }

    private static void exit() {
        System.out.println("Thank you for using the Camera Rental App. Exiting...");
        System.exit(0);
    }
}

class User_details {
    private String username;
    private String password;
   
    public User_details(String username, String password) {
        this.username = username;
        this.password = password;
        this.cameraList = new ArrayList<>();
        this.walletBalance = 1000.0;
    }
    //Creating list of Camera
    private List<Camera> cameraList;
    private double walletBalance;
    
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public List<Camera> getCameraList() {
        return cameraList;
    }
    public double getWalletBalance() {
        return walletBalance;
    }
   public void addCamera(Camera camera) {
        cameraList.add(camera);
    }
   public void removeCamera(int cameraId) {
        Camera camera = getCameraById(cameraId);
        if (camera != null) {
            cameraList.remove(camera);
        }
    }

    public Camera getCameraById(int cameraId) {
        for (Camera camera : cameraList) {
            if (camera.getId() == cameraId) {
                return camera;
            }
        }
        return null;
    }

    public void depositToWallet(double amount) {
        walletBalance += amount;
    }
}
class Camera {
    private int id;
    private String brand;
    private String model;
    private double rentalPrice;
    private boolean rented;

    public Camera(int id, String brand, String model, double rentalPrice, boolean rented) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.rentalPrice = rentalPrice;
        this.rented = rented;
    }
    public int getId() {
        return id;
    }
    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }
    public double getRentalPrice() {
        return rentalPrice;
    }
    public boolean isRented() {
        return rented;
    }
    public void setRented(boolean rented) {
        this.rented = rented;
    }
}
