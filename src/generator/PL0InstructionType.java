package generator;

public enum PL0InstructionType {
    LIT, // LIT 0, A ulož konstantu A do zásobníku
    OPR, // OPR 0, A proveď instrukci A
    LOD, // lod L,A    ulož hodnotu proměnné z adr. L,A na vrchol zásobníku
    STO, // sto L,A    zapiš do proměnné z adr. L,A hodnotu z vrcholu zásobníku
    CAL, // cal L,A    volej proceduru A z úrovně L
    INT, // int 0,A    zvyš obsah top-registru zásobníku o hodnotu A
    JMP, // jmp 0,A    proveď skok na adresu A
    JMC, // jmc 0,A    proveď skok na adresu A, je-li hodnota na vrcholu zásobníku 0
    RET // ret 0,0    návrat z procedury (return)
}





