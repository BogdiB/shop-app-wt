import { sendOrder } from "../global/api";
import styles from "../css/checkout.module.css";
import { useState } from "react";

function Checkout() {
    const [display, setDisplay] = useState(false);
    const [formDone, setFormDone] = useState(false);

    return (
    <>
        <button disabled={!formDone} onClick={() => setDisplay(!display)}>Order</button>
        <div className={styles.modalBackground + " " + (!display && styles.none)}>
            <div className={styles.modal}>
                <div className={styles.modalContent}>
                    <br />
                    <p>Thank you for your purchase!</p>
                    <br />
                    <p>Returning you to the home page...</p>
                    <br />
                </div>
            </div>
        </div>
    </>
    );
}

export default Checkout;