package dev.toma.pubgmc.client.models.vehicles;

import dev.toma.pubgmc.common.entity.vehicles.EntityVehicleUAZ;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;


public class ModelUAZ extends ModelVehicle<EntityVehicleUAZ> {

    private final ModelRenderer bone;
    private final ModelRenderer a1;
    private final ModelRenderer engineC;
    private final ModelRenderer a2;
    private final ModelRenderer bone4;
    private final ModelRenderer wheelC1;
    private final ModelRenderer wheelC2;
    private final ModelRenderer wheelFR;
    private final ModelRenderer a3;
    private final ModelRenderer a4;
    private final ModelRenderer wheelFL;
    private final ModelRenderer a10;
    private final ModelRenderer a5;
    private final ModelRenderer wheelBR;
    private final ModelRenderer a6;
    private final ModelRenderer a9;
    private final ModelRenderer decorations;
    private final ModelRenderer wheelBL;
    private final ModelRenderer a11;
    private final ModelRenderer a7;
    private final ModelRenderer mirror;
    private final ModelRenderer mirror2;
    private final ModelRenderer interior;
    private final ModelRenderer seat;
    private final ModelRenderer steering_wheel;
    private final ModelRenderer sh0;
    private final ModelRenderer sh1;
    private final ModelRenderer wheelBL2;
    private final ModelRenderer a12;
    private final ModelRenderer a8;

    public ModelUAZ() {
        textureWidth = 512;
        textureHeight = 512;

        bone = new ModelRenderer(this);
        bone.setRotationPoint(0.0F, 24.0F, 0.0F);
        bone.cubeList.add(new ModelBox(bone, 0, 0, -27.0F, -44.0F, -18.0F, 54, 2, 52, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 0, 0, -27.0F, -42.0F, 32.0F, 54, 2, 2, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 0, 0, 20.0F, -40.0F, 32.0F, 7, 13, 2, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 0, 0, -27.0F, -40.0F, 32.0F, 7, 13, 2, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 0, 0, -27.0F, -27.0F, 32.0F, 54, 14, 2, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 0, 0, -27.0F, -42.0F, -18.0F, 2, 2, 50, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 0, 0, 25.0F, -42.0F, -17.0F, 2, 2, 49, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 0, 0, -27.0F, -41.0F, -5.0F, 2, 15, 2, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 0, 0, -27.0F, -26.0F, -28.0F, 2, 13, 60, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 0, 0, 25.0F, -40.0F, -5.0F, 2, 15, 2, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 0, 0, 25.0F, -26.0F, -28.0F, 2, 13, 60, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 0, 0, -27.0F, -40.0F, 27.0F, 2, 14, 5, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 0, 0, 25.0F, -40.0F, 27.0F, 2, 14, 5, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 0, 0, -27.0F, -23.0F, -56.0F, 54, 10, 30, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 0, 0, -27.0F, -13.0F, -56.0F, 54, 9, 9, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 0, 0, -27.0F, -13.0F, 27.0F, 54, 10, 7, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 0, 0, -27.0F, -13.0F, -25.0F, 54, 10, 30, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 440, 222, -17.0F, -5.0F, -37.0F, 34, 2, 2, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 440, 222, -17.0F, -5.0F, 15.0F, 34, 2, 2, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 400, 227, -1.0F, -4.0F, -37.0F, 2, 2, 54, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 414, 222, 11.0F, -5.0F, -8.0F, 4, 4, 45, 0.0F, false));

        a1 = new ModelRenderer(this);
        a1.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(a1, -0.5236F, 0.0F, 0.0F);
        bone.addChild(a1);
        a1.cubeList.add(new ModelBox(a1, 0, 0, -27.0F, -29.0F, -37.0F, 3, 21, 2, 0.0F, false));
        a1.cubeList.add(new ModelBox(a1, 0, 0, 24.0F, -29.0F, -37.0F, 3, 21, 2, 0.0F, false));
        a1.cubeList.add(new ModelBox(a1, 0, 0, -24.0F, -29.0F, -37.0F, 48, 3, 2, 0.0F, false));
        a1.cubeList.add(new ModelBox(a1, 0, 0, -27.0F, -11.0F, -37.0F, 54, 4, 2, 0.0F, false));

        engineC = new ModelRenderer(this);
        engineC.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(engineC, 0.0873F, 0.0F, 0.0F);
        bone.addChild(engineC);
        engineC.cubeList.add(new ModelBox(engineC, 0, 0, -27.0F, -27.7F, -53.0F, 54, 9, 30, 0.0F, false));

        a2 = new ModelRenderer(this);
        a2.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(a2, 0.3491F, 0.0F, 0.0F);
        bone.addChild(a2);
        a2.cubeList.add(new ModelBox(a2, 0, 0, 25.0F, -35.0F, 23.0F, 2, 17, 2, 0.0F, false));
        a2.cubeList.add(new ModelBox(a2, 0, 0, -27.0F, -35.0F, 23.0F, 2, 17, 2, 0.0F, false));

        bone4 = new ModelRenderer(this);
        bone4.setRotationPoint(0.0F, 0.0F, 0.0F);
        bone.addChild(bone4);

        wheelC1 = new ModelRenderer(this);
        wheelC1.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(wheelC1, -0.2618F, 0.0F, 0.0F);
        bone.addChild(wheelC1);
        wheelC1.cubeList.add(new ModelBox(wheelC1, 0, 0, -27.0F, -2.0F, -49.0F, 54, 10, 3, 0.0F, false));
        wheelC1.cubeList.add(new ModelBox(wheelC1, 0, 0, -27.0F, -17.0F, 1.0F, 54, 12, 3, 0.0F, false));

        wheelC2 = new ModelRenderer(this);
        wheelC2.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(wheelC2, 0.2618F, 0.0F, 0.0F);
        bone.addChild(wheelC2);
        wheelC2.cubeList.add(new ModelBox(wheelC2, 0, 0, -27.0F, -7.0F, 27.0F, 54, 10, 3, 0.0F, false));
        wheelC2.cubeList.add(new ModelBox(wheelC2, 0, 0, -27.0F, -21.0F, -24.0F, 54, 11, 4, 0.0F, false));

        wheelFR = new ModelRenderer(this);
        wheelFR.setRotationPoint(-21.0F, 20.0F, -36.0F);
        wheelFR.cubeList.add(new ModelBox(wheelFR, 467, 358, -4.0F, -6.0F, -6.0F, 8, 12, 12, 0.0F, false));
        wheelFR.cubeList.add(new ModelBox(wheelFR, 249, 222, -5.0F, -5.0F, 5.0F, 10, 10, 3, 0.0F, false));
        wheelFR.cubeList.add(new ModelBox(wheelFR, 249, 222, -5.0F, -8.0F, -5.0F, 10, 3, 10, 0.0F, false));
        wheelFR.cubeList.add(new ModelBox(wheelFR, 249, 222, -5.0F, 5.0F, -5.0F, 10, 3, 10, 0.0F, false));
        wheelFR.cubeList.add(new ModelBox(wheelFR, 249, 222, -5.0F, -5.0F, -8.0F, 10, 10, 3, 0.0F, false));

        a3 = new ModelRenderer(this);
        a3.setRotationPoint(21.0F, 4.0F, 36.0F);
        setRotationAngle(a3, -0.7854F, 0.0F, 0.0F);
        wheelFR.addChild(a3);
        a3.cubeList.add(new ModelBox(a3, 249, 222, -26.0F, 20.5985F, -22.0843F, 10, 4, 3, 0.0F, false));
        a3.cubeList.add(new ModelBox(a3, 249, 222, -26.0F, 20.5985F, -37.4843F, 10, 4, 3, 0.0F, false));

        a4 = new ModelRenderer(this);
        a4.setRotationPoint(21.0F, 4.0F, 36.0F);
        setRotationAngle(a4, 0.7854F, 0.0F, 0.0F);
        wheelFR.addChild(a4);
        a4.cubeList.add(new ModelBox(a4, 249, 222, -26.0F, -30.2843F, -16.4985F, 10, 4, 3, 0.0F, false));
        a4.cubeList.add(new ModelBox(a4, 249, 222, -26.0F, -30.2843F, -31.7985F, 10, 4, 3, 0.0F, false));

        wheelFL = new ModelRenderer(this);
        wheelFL.setRotationPoint(21.0F, 20.0F, -36.0F);
        wheelFL.cubeList.add(new ModelBox(wheelFL, 468, 360, -4.0F, -6.0F, -6.0F, 8, 12, 12, 0.0F, false));
        wheelFL.cubeList.add(new ModelBox(wheelFL, 249, 222, -5.0F, -5.0F, 5.0F, 10, 10, 3, 0.0F, false));
        wheelFL.cubeList.add(new ModelBox(wheelFL, 249, 222, -5.0F, -8.0F, -5.0F, 10, 3, 10, 0.0F, false));
        wheelFL.cubeList.add(new ModelBox(wheelFL, 249, 222, -5.0F, 5.0F, -5.0F, 10, 3, 10, 0.0F, false));
        wheelFL.cubeList.add(new ModelBox(wheelFL, 249, 222, -5.0F, -5.0F, -8.0F, 10, 10, 3, 0.0F, false));

        a10 = new ModelRenderer(this);
        a10.setRotationPoint(-21.0F, 4.0F, 36.0F);
        setRotationAngle(a10, -0.7854F, 0.0F, 0.0F);
        wheelFL.addChild(a10);
        a10.cubeList.add(new ModelBox(a10, 249, 222, 16.0F, 20.5985F, -22.0843F, 10, 4, 3, 0.0F, false));
        a10.cubeList.add(new ModelBox(a10, 249, 222, 16.0F, 20.5985F, -37.4843F, 10, 4, 3, 0.0F, false));

        a5 = new ModelRenderer(this);
        a5.setRotationPoint(-21.0F, 4.0F, 36.0F);
        setRotationAngle(a5, 0.7854F, 0.0F, 0.0F);
        wheelFL.addChild(a5);
        a5.cubeList.add(new ModelBox(a5, 249, 222, 16.0F, -30.2843F, -16.4985F, 10, 4, 3, 0.0F, false));
        a5.cubeList.add(new ModelBox(a5, 249, 222, 16.0F, -30.2843F, -31.7985F, 10, 4, 3, 0.0F, false));

        wheelBR = new ModelRenderer(this);
        wheelBR.setRotationPoint(-21.0F, 20.0F, 16.0F);
        wheelBR.cubeList.add(new ModelBox(wheelBR, 470, 356, -4.0F, -6.0F, -6.0F, 8, 12, 12, 0.0F, false));
        wheelBR.cubeList.add(new ModelBox(wheelBR, 249, 222, -5.0F, -5.0F, 5.0F, 10, 10, 3, 0.0F, false));
        wheelBR.cubeList.add(new ModelBox(wheelBR, 249, 222, -5.0F, -8.0F, -5.0F, 10, 3, 10, 0.0F, false));
        wheelBR.cubeList.add(new ModelBox(wheelBR, 249, 222, -5.0F, 5.0F, -5.0F, 10, 3, 10, 0.0F, false));
        wheelBR.cubeList.add(new ModelBox(wheelBR, 249, 222, -5.0F, -5.0F, -8.0F, 10, 10, 3, 0.0F, false));

        a6 = new ModelRenderer(this);
        a6.setRotationPoint(21.0F, 4.0F, -16.0F);
        setRotationAngle(a6, -0.7854F, 0.0F, 0.0F);
        wheelBR.addChild(a6);
        a6.cubeList.add(new ModelBox(a6, 249, 222, -26.0F, -16.1711F, 14.6853F, 10, 4, 3, 0.0F, false));
        a6.cubeList.add(new ModelBox(a6, 249, 222, -26.0F, -16.1711F, -0.7147F, 10, 4, 3, 0.0F, false));

        a9 = new ModelRenderer(this);
        a9.setRotationPoint(21.0F, 4.0F, -16.0F);
        setRotationAngle(a9, 0.7854F, 0.0F, 0.0F);
        wheelBR.addChild(a9);
        a9.cubeList.add(new ModelBox(a9, 249, 222, -26.0F, 6.4853F, 20.2711F, 10, 4, 3, 0.0F, false));
        a9.cubeList.add(new ModelBox(a9, 249, 222, -26.0F, 6.4853F, 4.9711F, 10, 4, 3, 0.0F, false));

        decorations = new ModelRenderer(this);
        decorations.setRotationPoint(0.0F, 24.0F, 0.0F);
        decorations.cubeList.add(new ModelBox(decorations, 490, 356, 17.0F, -16.0F, -57.0F, 8, 8, 1, 0.0F, false));
        decorations.cubeList.add(new ModelBox(decorations, 490, 356, -25.0F, -16.0F, -57.0F, 8, 8, 1, 0.0F, false));
        decorations.cubeList.add(new ModelBox(decorations, 391, 222, -29.0F, -8.0F, -60.0F, 58, 6, 2, 0.0F, false));
        decorations.cubeList.add(new ModelBox(decorations, 395, 222, -28.0F, -13.0F, -60.0F, 56, 2, 2, 0.0F, false));
        decorations.cubeList.add(new ModelBox(decorations, 395, 222, -28.0F, -18.0F, -60.0F, 56, 2, 2, 0.0F, false));
        decorations.cubeList.add(new ModelBox(decorations, 395, 222, 26.0F, -18.0F, -60.0F, 2, 10, 2, 0.0F, false));
        decorations.cubeList.add(new ModelBox(decorations, 395, 222, -28.0F, -18.0F, -60.0F, 2, 10, 2, 0.0F, false));
        decorations.cubeList.add(new ModelBox(decorations, 395, 222, -10.0F, -23.0F, -60.0F, 2, 15, 2, 0.0F, false));
        decorations.cubeList.add(new ModelBox(decorations, 395, 222, 8.0F, -23.0F, -60.0F, 2, 15, 2, 0.0F, false));
        decorations.cubeList.add(new ModelBox(decorations, 395, 222, -9.0F, -23.0F, -60.0F, 18, 2, 2, 0.0F, false));
        decorations.cubeList.add(new ModelBox(decorations, 395, 222, -10.0F, -18.0F, -58.0F, 2, 15, 2, 0.0F, false));
        decorations.cubeList.add(new ModelBox(decorations, 395, 222, 8.0F, -18.0F, -58.0F, 2, 15, 2, 0.0F, false));
        decorations.cubeList.add(new ModelBox(decorations, 395, 222, 26.0F, -21.0F, -12.0F, 2, 2, 5, 0.0F, false));
        decorations.cubeList.add(new ModelBox(decorations, 395, 222, 26.0F, -21.0F, 8.0F, 2, 2, 5, 0.0F, false));
        decorations.cubeList.add(new ModelBox(decorations, 395, 222, -28.0F, -21.0F, 8.0F, 2, 2, 5, 0.0F, false));
        decorations.cubeList.add(new ModelBox(decorations, 395, 222, -28.0F, -21.0F, -12.0F, 2, 2, 5, 0.0F, false));
        decorations.cubeList.add(new ModelBox(decorations, 490, 356, 18.0F, -18.0F, 34.0F, 5, 8, 1, 0.0F, false));
        decorations.cubeList.add(new ModelBox(decorations, 490, 356, -22.0F, -18.0F, 34.0F, 5, 8, 1, 0.0F, false));
        decorations.cubeList.add(new ModelBox(decorations, 395, 222, 27.0F, -23.0F, -28.0F, 4, 2, 2, 0.0F, false));
        decorations.cubeList.add(new ModelBox(decorations, 395, 222, -31.0F, -23.0F, -28.0F, 4, 2, 2, 0.0F, false));
        decorations.cubeList.add(new ModelBox(decorations, 395, 222, -28.0F, -8.0F, 34.0F, 56, 6, 2, 0.0F, false));

        wheelBL = new ModelRenderer(this);
        wheelBL.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(wheelBL, 0.0F, -1.5708F, 0.0F);
        decorations.addChild(wheelBL);
        wheelBL.cubeList.add(new ModelBox(wheelBL, 465, 355, 34.0F, -23.0F, -5.0F, 8, 12, 12, 0.0F, false));
        wheelBL.cubeList.add(new ModelBox(wheelBL, 249, 222, 33.0F, -22.0F, 6.0F, 10, 10, 3, 0.0F, false));
        wheelBL.cubeList.add(new ModelBox(wheelBL, 249, 222, 33.0F, -25.0F, -4.0F, 10, 3, 10, 0.0F, false));
        wheelBL.cubeList.add(new ModelBox(wheelBL, 249, 222, 33.0F, -12.0F, -4.0F, 10, 3, 10, 0.0F, false));
        wheelBL.cubeList.add(new ModelBox(wheelBL, 249, 222, 33.0F, -22.0F, -7.0F, 10, 10, 3, 0.0F, false));

        a11 = new ModelRenderer(this);
        a11.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(a11, -0.7854F, 0.0F, 0.0F);
        wheelBL.addChild(a11);
        a11.cubeList.add(new ModelBox(a11, 249, 222, 33.0F, -14.7569F, -5.1137F, 10, 4, 3, 0.0F, false));
        a11.cubeList.add(new ModelBox(a11, 249, 222, 33.0F, -14.7569F, -20.5137F, 10, 4, 3, 0.0F, false));

        a7 = new ModelRenderer(this);
        a7.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(a7, 0.7854F, 0.0F, 0.0F);
        wheelBL.addChild(a7);
        a7.cubeList.add(new ModelBox(a7, 249, 222, 33.0F, -13.3137F, 18.8569F, 10, 4, 3, 0.0F, false));
        a7.cubeList.add(new ModelBox(a7, 249, 222, 33.0F, -13.3137F, 3.5568F, 10, 4, 3, 0.0F, false));

        mirror = new ModelRenderer(this);
        mirror.setRotationPoint(0.0F, 24.0F, 0.0F);
        setRotationAngle(mirror, 0.0F, -0.1745F, 0.0F);
        mirror.cubeList.add(new ModelBox(mirror, 395, 222, 24.0F, -31.0F, -32.0F, 6, 12, 2, 0.0F, false));

        mirror2 = new ModelRenderer(this);
        mirror2.setRotationPoint(0.0F, 24.0F, 0.0F);
        setRotationAngle(mirror2, 0.0F, 0.1745F, 0.0F);
        mirror2.cubeList.add(new ModelBox(mirror2, 395, 222, -30.0F, -31.0F, -32.0F, 6, 12, 2, 0.0F, false));

        interior = new ModelRenderer(this);
        interior.setRotationPoint(0.0F, 24.0F, 0.0F);
        interior.cubeList.add(new ModelBox(interior, 434, 220, 2.0F, -16.0F, -17.0F, 19, 1, 19, 0.0F, false));
        interior.cubeList.add(new ModelBox(interior, 434, 220, -21.0F, -16.0F, -17.0F, 19, 1, 19, 0.0F, false));
        interior.cubeList.add(new ModelBox(interior, 374, 220, -25.0F, -17.0F, 6.0F, 50, 1, 18, 0.0F, false));
        interior.cubeList.add(new ModelBox(interior, 358, 224, -25.0F, -26.0F, -25.5F, 50, 12, 1, 0.0F, false));
        interior.cubeList.add(new ModelBox(interior, 358, 224, 24.9F, -25.0F, -25.5F, 1, 11, 52, 0.0F, false));
        interior.cubeList.add(new ModelBox(interior, 358, 224, -25.9F, -25.0F, -25.5F, 1, 11, 52, 0.0F, false));

        seat = new ModelRenderer(this);
        seat.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(seat, 1.3963F, 0.0F, 0.0F);
        interior.addChild(seat);
        seat.cubeList.add(new ModelBox(seat, 434, 220, 2.0F, -2.0F, 15.0F, 19, 1, 19, 0.0F, false));
        seat.cubeList.add(new ModelBox(seat, 434, 220, -21.0F, -2.0F, 15.0F, 19, 1, 19, 0.0F, false));
        seat.cubeList.add(new ModelBox(seat, 251, 222, -20.0F, 20.0F, 21.0F, 41, 1, 19, 0.0F, false));

        steering_wheel = new ModelRenderer(this);
        steering_wheel.setRotationPoint(11.0F, 2.5F, -23.0F);
        steering_wheel.cubeList.add(new ModelBox(steering_wheel, 382, 355, -6.0F, -8.5F, 0.0F, 12, 1, 1, 0.0F, false));
        steering_wheel.cubeList.add(new ModelBox(steering_wheel, 382, 355, -6.0F, 7.5F, 0.0F, 12, 1, 1, 0.0F, false));
        steering_wheel.cubeList.add(new ModelBox(steering_wheel, 382, 355, -9.0F, -5.5F, 0.0F, 1, 11, 1, 0.0F, false));
        steering_wheel.cubeList.add(new ModelBox(steering_wheel, 382, 355, 8.0F, -5.5F, 0.0F, 1, 11, 1, 0.0F, false));
        steering_wheel.cubeList.add(new ModelBox(steering_wheel, 382, 355, -4.5F, -4.5F, 0.0F, 9, 9, 1, 0.0F, false));
        steering_wheel.cubeList.add(new ModelBox(steering_wheel, 382, 355, -4.0F, -5.0F, 0.0F, 8, 1, 1, 0.0F, false));
        steering_wheel.cubeList.add(new ModelBox(steering_wheel, 382, 355, -4.0F, 4.0F, 0.0F, 8, 1, 1, 0.0F, false));
        steering_wheel.cubeList.add(new ModelBox(steering_wheel, 382, 355, -5.0F, -4.0F, 0.0F, 1, 8, 1, 0.0F, false));
        steering_wheel.cubeList.add(new ModelBox(steering_wheel, 382, 355, 4.0F, -4.0F, 0.0F, 1, 8, 1, 0.0F, false));
        steering_wheel.cubeList.add(new ModelBox(steering_wheel, 382, 355, -1.0F, 5.0F, 0.0F, 2, 3, 1, 0.0F, false));
        steering_wheel.cubeList.add(new ModelBox(steering_wheel, 382, 355, -8.0F, -1.0F, 0.0F, 3, 2, 1, 0.0F, false));
        steering_wheel.cubeList.add(new ModelBox(steering_wheel, 382, 355, 5.0F, -1.0F, 0.0F, 3, 2, 1, 0.0F, false));
        steering_wheel.cubeList.add(new ModelBox(steering_wheel, 382, 355, -3.5F, -3.5F, -3.0F, 7, 7, 3, 0.0F, false));

        sh0 = new ModelRenderer(this);
        sh0.setRotationPoint(-11.0F, 21.5F, 23.0F);
        setRotationAngle(sh0, 0.0F, 0.0F, -0.7854F);
        steering_wheel.addChild(sh0);
        sh0.cubeList.add(new ModelBox(sh0, 382, 355, 20.5873F, -17.597F, -23.0F, 4, 1, 1, 0.0F, false));
        sh0.cubeList.add(new ModelBox(sh0, 382, 355, 21.3373F, 1.803F, -23.0F, 4, 1, 1, 0.0F, false));

        sh1 = new ModelRenderer(this);
        sh1.setRotationPoint(-11.0F, 21.5F, 23.0F);
        setRotationAngle(sh1, 0.0F, 0.0F, 0.7854F);
        steering_wheel.addChild(sh1);
        sh1.cubeList.add(new ModelBox(sh1, 382, 355, -9.747F, -13.5873F, -23.0F, 4, 1, 1, 0.0F, false));
        sh1.cubeList.add(new ModelBox(sh1, 382, 355, -9.097F, -33.1873F, -23.0F, 4, 1, 1, 0.0F, false));

        wheelBL2 = new ModelRenderer(this);
        wheelBL2.setRotationPoint(21.0F, 20.0F, 16.0F);
        wheelBL2.cubeList.add(new ModelBox(wheelBL2, 471, 356, -4.0F, -6.0F, -6.0F, 8, 12, 12, 0.0F, false));
        wheelBL2.cubeList.add(new ModelBox(wheelBL2, 249, 222, -5.0F, -5.0F, 5.0F, 10, 10, 3, 0.0F, false));
        wheelBL2.cubeList.add(new ModelBox(wheelBL2, 249, 222, -5.0F, -8.0F, -5.0F, 10, 3, 10, 0.0F, false));
        wheelBL2.cubeList.add(new ModelBox(wheelBL2, 249, 222, -5.0F, 5.0F, -5.0F, 10, 3, 10, 0.0F, false));
        wheelBL2.cubeList.add(new ModelBox(wheelBL2, 249, 222, -5.0F, -5.0F, -8.0F, 10, 10, 3, 0.0F, false));

        a12 = new ModelRenderer(this);
        a12.setRotationPoint(-21.0F, 4.0F, -16.0F);
        setRotationAngle(a12, -0.7854F, 0.0F, 0.0F);
        wheelBL2.addChild(a12);
        a12.cubeList.add(new ModelBox(a12, 249, 222, 16.0F, -16.1711F, 14.6853F, 10, 4, 3, 0.0F, false));
        a12.cubeList.add(new ModelBox(a12, 249, 222, 16.0F, -16.1711F, -0.7147F, 10, 4, 3, 0.0F, false));

        a8 = new ModelRenderer(this);
        a8.setRotationPoint(-21.0F, 4.0F, -16.0F);
        setRotationAngle(a8, 0.7854F, 0.0F, 0.0F);
        wheelBL2.addChild(a8);
        a8.cubeList.add(new ModelBox(a8, 249, 222, 16.0F, 6.4853F, 20.2711F, 10, 4, 3, 0.0F, false));
        a8.cubeList.add(new ModelBox(a8, 249, 222, 16.0F, 6.4853F, 4.9711F, 10, 4, 3, 0.0F, false));
    }

    @Override
    public void render(EntityVehicleUAZ vehicle) {
        bone.render(1f);
        wheelBR.render(1f);
        wheelBL2.render(1f);
        decorations.render(1f);
        mirror.render(1f);
        mirror2.render(1f);
        interior.render(1f);
        renderSteeringWheel(steering_wheel, vehicle.turnModifier);
        renderFrontWheel(wheelFR, vehicle.turnModifier);
        renderFrontWheel(wheelFL, vehicle.turnModifier);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
